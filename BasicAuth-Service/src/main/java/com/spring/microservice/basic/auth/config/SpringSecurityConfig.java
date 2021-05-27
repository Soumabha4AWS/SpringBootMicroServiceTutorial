package com.spring.microservice.basic.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		/* Security for all API */
		// http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		/* Security for specific URL */
		// http.authorizeRequests().antMatchers("/auth/greeting/**").fullyAuthenticated().and().httpBasic();
		/* Security for specific Role */
		http.authorizeRequests()
					.antMatchers("/admin-auth/greeting/**").hasRole("ADMIN")
					.antMatchers("/user-auth/greeting/**").hasRole("USER")
		.anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder()  {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
