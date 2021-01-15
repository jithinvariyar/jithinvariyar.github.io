package com.jithin.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser(users.username("Jithin").password("123@jithin").roles("EMPLOYEE"));
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("Jishnu").password("123@jishnu").roles("EMPLOYEE","MANAGER"));
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("Prasad").password("123@prasad").roles("EMPLOYEE","ADMIN"));
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
	
	
}
