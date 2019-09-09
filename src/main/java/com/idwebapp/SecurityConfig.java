package com.idwebapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * Query para obtener el usuario por username
		 */
		String sqlUsername = "select * from (select usuario as username, clave as password,"
				+ "habilitado as enabled from usuario) as users where username = ?";
		
		/*
		 * Query para obtener los roles por username
		 */
		String sqlRoles = "select * from (select u.usuario as username, r.rol as AUTHORITY from "
				+ "usuario u inner join usuario_roles ur on u.id = ur.usuario_id inner join rol "
				+ "r on r.id = ur.rol_id) as authorities where username = ?";

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder)
				.usersByUsernameQuery(sqlUsername)
				.authoritiesByUsernameQuery(sqlRoles);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/nominas/gestion/nominas").access("hasRole('ROLE_HUMANR') or hasRole('ROLE_AUDITOR')")
			.antMatchers("/nominas/gestion/trabajadores").access("hasRole('ROLE_HUMANR')")
			.antMatchers("/compras/autorizar").access("hasRole('ROLE_MANAGEMENT')")
			.antMatchers("/compras/gestion/compras").access("hasRole('ROLE_PURCHASES') or hasRole('ROLE_AUDITOR')")
			.antMatchers("/compras/gestion/proveedores").access("hasRole('ROLE_PURCHASES')")
			.antMatchers("/ventas/gestion/clientes").access("hasRole('ROLE_SALES') or hasRole('ROLE_AUDITOR')")
			.antMatchers("/ventas/gestion/facturas").access("hasRole('ROLE_SALES')")
			.antMatchers("/ventas/gestion/presupuestos").access("hasRole('ROLE_SALES')")
			.antMatchers("/menu").access("isAuthenticated()")
			.antMatchers("/menu/**").access("isAuthenticated()")
			.and().formLogin()
			.loginPage("/login").loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/menu")
			.failureUrl("/login?error").usernameParameter("usuario").passwordParameter("clave").and()
			.logout().logoutSuccessUrl("/login").logoutUrl("/j_spring_security_logout").and()
			.exceptionHandling().accessDeniedPage("/denegado").and().csrf();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
