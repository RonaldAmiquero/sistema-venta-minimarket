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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.cientifica.minimarket.model.Persona;
import edu.cientifica.minimarket.model.Proveedor;
import edu.cientifica.minimarket.services.PersonaService;
import edu.cientifica.minimarket.services.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	protected final Log LOG =  LogFactory.getLog(this.getClass());
	
	
	@Autowired
	ProveedorService proveedorService;
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/form")
	public String formularioProveedor(Model model)  {
		
		Proveedor proveedor = new Proveedor();
		proveedor.setId(proveedorService.asignarId());
		model.addAttribute("Proveedor", proveedor);
		return "registrarProveedores";
	}
	@PostMapping("/registrar")
	public String registrarProveedor(@Valid @ModelAttribute("Proveedor") Proveedor proveedor, 
			BindingResult errors, Model model, RedirectAttributes atribute) {
		 
	
		if (errors.hasErrors()) {
			LOG.info("numero de errores: "+errors.getErrorCount());
			for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error "+oe.getCode()+" "+oe.getObjectName()+oe.getDefaultMessage());
			}
			return ("registrarProveedores");
		}
		
		try {
			@SuppressWarnings("unused")
			int resultPersona= personaService.registrarPersona(proveedor);
			@SuppressWarnings("unused")
			int resultProveedor =proveedorService.registrarProveedor(proveedor);
		} catch (Exception e) {
			LOG.info("ERROR" + e.getMessage());
		}

		return "redirect:/proveedor/form";
	}
	@GetMapping("/lista")
	public String listaProveedor(Model model) {
		List<Proveedor> listaProveedores;
		listaProveedores= proveedorService.listarProveedores();
		model.addAttribute("proveedores", listaProveedores);
		model.addAttribute("proveedor", new Proveedor());
		return "gestionarProveedores";

	}
	@GetMapping("/edit/{id}")
	public String editarProveedor(Model model, @PathVariable("id") int id) {
		
		
		Persona  persona = new Persona();
		persona =personaService.buscarPersonarId(id);
		
		Proveedor proveedor =  new Proveedor();
		proveedor = proveedorService.buscarProveedorId(id);
		
	    proveedor.setId(persona.getId());
	    proveedor.setNombre(persona.getNombre());
	    proveedor.setEmail(persona.getEmail());
	    proveedor.setTelefono(persona.getTelefono());
	    proveedor.setDireccion(persona.getDireccion());
	    
	    model.addAttribute("Proveedor", proveedor);
			
								
		return "registrarProveedores_edit";
		
	
		
	}
	
	@PostMapping("/actualizar")
	public String actualizarProveedor(@Valid @ModelAttribute("Proveedor") Proveedor proveedor, 
			BindingResult errors, Model model, RedirectAttributes redirectAttrs) {
		
			if (errors.hasErrors()) {
				
			    for (ObjectError oe : errors.getAllErrors()) {
				LOG.info("error"+oe.getCode()+" "+oe.getObjectName()+oe.getDefaultMessage());
			}
			redirectAttrs
			.addFlashAttribute("mensaje", "Ocurrio un error al actualizar")
			.addFlashAttribute("clase", "warning");
			
			return ("redirect:/proveedor/lista");
		}
		
		LOG.info("PROVEEDOR" + proveedor.toString());
		
		
		try {
			@SuppressWarnings("unused")
			int resultPersona =personaService.actualizarPersona(proveedor);
			@SuppressWarnings("unused")
			int resultProveedor =proveedorService.actualizarProveedor(proveedor);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}

		return "redirect:/proveedor/lista";
		
	}
}
