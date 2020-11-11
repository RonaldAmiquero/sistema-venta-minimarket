package edu.cientifica.minimarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UsuarioController {
	
	//@Autowired UsuarioService usuarioService;
	
	
	@RequestMapping (value = {"/","/index","/home"}, method = RequestMethod.GET)
	public String cargaInicial() {
		
		return "principal";
	}
	
	/*@RequestMapping (value = {"/login"}, method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	*/
	
	/*@RequestMapping(value = "/validar", method = RequestMethod.POST)*/
	@PostMapping("/validar")
	public String validarUsuario(Model model,  
			@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) 
	{
		//Usuario usuario =  new Usuario( 0, username, password);
		
		/*if (usuarioService.validarUsuario(usuario)) {
			return "principal";
			
		};
		
		*/
		return "login";
	}
	
	@RequestMapping (value = {"/demo"}, method = RequestMethod.GET)
	public String demoForm() {
		
		return "demoform";
	}
	
	@GetMapping("/inicio")
	public String inicio() {
		
		return "principal";
	}

}
