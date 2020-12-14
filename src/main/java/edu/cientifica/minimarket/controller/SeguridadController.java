package edu.cientifica.minimarket.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.cientifica.minimarket.model.CuentaUsuario;
import edu.cientifica.minimarket.services.CuentaUsuarioService;

/*@Controller: anotacion para designar una clase Controlador del patron MVC*/
@Controller
@Scope("session")
@SessionAttributes("user")
public class SeguridadController {

	protected final Log LOG = LogFactory.getLog(this.getClass());
	@Autowired
	CuentaUsuarioService usuarioService;

	/* @GetMapping: anotacion spring, asocia la peticion GET con un metodo */
	@GetMapping(value = { "/", "/principal" , "/index"})
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "principal";
	}
	
	@GetMapping({"/login"})
	public String loginPage() {

		return "login";
	}
	
	@GetMapping({ "/logout" })
	public String logoutPage() {

		
		return "login";
	}
	
	@RequestMapping("/login-error")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login.html";
	  }

	/*
	 * @RequestMapping: anotacion que asocia peticiones (GET o POST) con un metodo
	 * 
	 * @RequestParam: anotacion que lee los parametros de peticiones POST
	 */
	@RequestMapping(value = { "/autenticacion" }, method = RequestMethod.POST)
	public String autenticacion(Model model, @RequestParam(name = "usuario") String username,
			@RequestParam(name = "password") String password) {
		String mensaje;
		CuentaUsuario usuario;

		usuario = new CuentaUsuario(username, password);
		if (usuarioService.validarUsuario(usuario)) {
			mensaje = "Password correcto";
			model.addAttribute("msg", mensaje);
			model.addAttribute("user", usuario);
			return "principal";
		} else {
			mensaje = "Password incorrecto";
			model.addAttribute("msg", mensaje);
			model.addAttribute("user", usuario);
			return "login";
		}
	}
}
