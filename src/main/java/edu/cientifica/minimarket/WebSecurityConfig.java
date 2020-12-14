package edu.cientifica.minimarket;

import java.security.CryptoPrimitive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	protected final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	public void configureAuthManager (AuthenticationManagerBuilder authenticationManagerBuilder)
	{
		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder, 
			UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		return daoAuthenticationProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.authorizeRequests()
				.antMatchers("/js/**", "/css/**", "/layout/**", "/img/**", "/jquery/**", "/vendor/**", "/i18n/**",
						"/logout/**", "/error/**").permitAll()
				.antMatchers("/proveedor/**","/producto/**","/usuario/**").hasAuthority("Administrador")
				.antMatchers("/venta/**").hasAnyAuthority("Cajero","Administrador")
				.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login").permitAll()
			//.defaultSuccessUrl("/")
			
			//.failureUrl("/login?error=true")
			.failureUrl("/login-error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.csrf().disable()
		.logout()
			.permitAll()
			.invalidateHttpSession(true).clearAuthentication(true)
			//.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logout-success")
			.logoutSuccessUrl("/login?logout");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	

}
