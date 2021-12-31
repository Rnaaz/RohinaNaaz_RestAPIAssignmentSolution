package com.greatlearning.EmployeeMangement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.EmployeeMangement.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(getPasswordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .antMatchers(HttpMethod.DELETE, "/api/employees/{employeeId}").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.POST, "/api/employees").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyAuthority("ADMIN", "USER")
        .antMatchers(HttpMethod.GET, "/api/employees/list","/api/employees/sort", "/api/employees/search").hasAnyAuthority("ADMIN", "USER")
        .antMatchers("/api/users/**").permitAll()
        .antMatchers(HttpMethod.POST, "/api/roles").hasAuthority("ADMIN")
        .and().httpBasic()
        .and().cors().and().csrf().disable().formLogin().disable();
		http.headers().frameOptions().disable();
				 
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}

}
