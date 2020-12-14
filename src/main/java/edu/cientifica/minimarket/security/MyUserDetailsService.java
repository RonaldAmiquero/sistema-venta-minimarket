package edu.cientifica.minimarket.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cientifica.minimarket.mappers.CuentaUsuarioMapper;
import edu.cientifica.minimarket.model.CuentaUsuario;


@Service
public class MyUserDetailsService implements UserDetailsService {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	private CuentaUsuarioMapper usuarioMapper;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CuentaUsuario user = usuarioMapper.encontrarNombreUsuario(username);
		
		
		//LOG.info("usuario db " + user.toString());
				 
		if (user == null) {
			throw new UsernameNotFoundException("No se encontro en la BD");
		}
			
		// TODO Auto-generated method stub
		return new UserPrincipal(user);
	}

}
