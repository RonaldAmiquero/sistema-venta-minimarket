package edu.cientifica.minimarket.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.cientifica.minimarket.model.CuentaUsuario;


public class UserPrincipal implements UserDetails {
	
	private CuentaUsuario user;
	

	public UserPrincipal(CuentaUsuario usuario) {
		super();
		this.user = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
       
        // Extract list of TipoUsuarios (TipoUsuarios)
      
          GrantedAuthority authority = new SimpleGrantedAuthority(user.getTipoUsuario());
          authorities.add(authority);
   

        return authorities;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getContrasenha();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "UserPrincipal [user=" + user.toString() + "]";
	}

	
}
