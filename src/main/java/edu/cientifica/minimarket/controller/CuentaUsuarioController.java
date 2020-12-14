package edu.cientifica.minimarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cientifica.minimarket.model.CuentaUsuario;
import edu.cientifica.minimarket.model.Empleado;
import edu.cientifica.minimarket.services.CuentaUsuarioService;
import edu.cientifica.minimarket.services.CuentaUsuario_PermisoService;
import edu.cientifica.minimarket.services.EmpleadoService;


@Controller
@RequestMapping("/usuario")
public class CuentaUsuarioController {
	
	protected final Log LOG =  LogFactory.getLog(this.getClass());

	@RequestMapping(value = { "/demo" }, method = RequestMethod.GET)
	public String demoForm() {

		return "demoform";
	}


	@Autowired
	EmpleadoService empleadoService;
	@Autowired
	CuentaUsuarioService usuarioService;
	@Autowired
	CuentaUsuario_PermisoService usuarioPermisoService;
	
	@GetMapping("/form")
	public String formularioCuentaUsuario(Model model) {
		CuentaUsuario cuentausuario=new CuentaUsuario();
		cuentausuario.setIdCuenta(usuarioService.completarId());
		model.addAttribute("CuentaUsuario", cuentausuario);
		List<Empleado> listaEmpleados;
		listaEmpleados = empleadoService.listarEmpleados();
		model.addAttribute("listaEmpleados", listaEmpleados);
		return "registrarUsuario";

	}

	@PostMapping("/registrar")
	public String registrarUsuario(@Valid @ModelAttribute("CuentaUsuario") CuentaUsuario usuario,
			BindingResult errors, Model model,	RedirectAttributes atribute) {
		if (errors.hasErrors()) {
			LOG.info("numero de errores: "+errors.getErrorCount());
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error "+oe.getCode()+" "+oe.getObjectName()+oe.getDefaultMessage());
			}
			return ("registrarUsuario");
		}

		try {
			@SuppressWarnings("unused")
			int resultUsuario =usuarioService.registrarUsuario(usuario);
			@SuppressWarnings("unused")
			int resultPermiso=usuarioPermisoService.registrarCuentaPermiso(usuario);
		
		} catch (Exception e) {
			LOG.info("ERROR" + e.getMessage());
		}
		
		
		return "redirect:/usuario/lista";
	}
	@GetMapping("/lista")
	public String listarUsuario(Model model) {
		List<CuentaUsuario> listaUsuario;
		listaUsuario= usuarioService.listarUsuario();
		model.addAttribute("CuentaUsuario", listaUsuario);
		model.addAttribute("usuario", new CuentaUsuario());
		return "gestionarUsuario";
	}
	@GetMapping("/edit/{id}")
	public String editarUsuario(Model model, @PathVariable(name="id") int idCuenta) {
		CuentaUsuario usuario = usuarioService.buscarCuentaUsuarioId(idCuenta);

		List<Empleado> listaEmpleados = empleadoService.listarEmpleados();
		model.addAttribute("listaEmpleados",listaEmpleados);
		model.addAttribute("CuentaUsuario", usuario);
		
		return "registrarUsuario_edit";
	}
	
	@PostMapping("/actualizar")
	public String actualizarUsuario( @Valid @ModelAttribute("CuentaUsuario") CuentaUsuario usuario, 
			BindingResult errors, Model model, RedirectAttributes redirectAttrs) {
		
		if (errors.hasErrors()) {
			
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error"+oe.getCode()+" "+oe.getObjectName()+oe.getDefaultMessage());
			}
			redirectAttrs
			.addFlashAttribute("mensaje", "Ocurrio un error al actualizar")
			.addFlashAttribute("clase", "warning");
			
			return ("redirect:/usuario/lista");
		}
		
		LOG.info("USUARIO " + usuario.toString());
		
		try {
			
			@SuppressWarnings("unused")
			int resultUsuario = usuarioService.actualizarCuentaUsuario(usuario);
			@SuppressWarnings("unused")
			int resultPermiso = usuarioPermisoService.actualizarCuentaPermiso(usuario);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}

		return "redirect:/usuario/lista";
	}
}
