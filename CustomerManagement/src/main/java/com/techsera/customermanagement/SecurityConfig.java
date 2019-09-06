/*package com.techsera.customermanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("anuj").password(passwordEncoder().encode("soni")).roles("ADMIN")
			.and()
			.withUser("aks").password(passwordEncoder().encode("soni")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		 authorizeRequests().antMatchers("/").permitAll().and()
         .authorizeRequests().antMatchers("/h2-console/**").permitAll();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
*/