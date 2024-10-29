package com.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService getDetailsService() {

		return new CustomUserDetailsService();
	}

	@Bean
	DaoAuthenticationProvider getAuthenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoAuthenticationProvider;
	}
	
	///SecurityFilter chain configuration. it is an interface.
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/","/habitaciones","/empleado","/quienes-somos","/servicios","/register","/signin","/saveUser").permitAll()
		.requestMatchers("/user/**").authenticated().and()
		.formLogin().loginPage("/signin").loginProcessingUrl("/userLogin")
		//.usernameParameter("email")
		.defaultSuccessUrl("/user/profile").permitAll();
		return http.build();
	}
}