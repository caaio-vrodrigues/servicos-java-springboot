package com.example.servico05.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http
	) throws Exception {
		return http
			.csrf(customizer -> customizer.disable())
			.authorizeHttpRequests(request -> 
				request
					.requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
					.permitAll()
					.requestMatchers("register", "/user/login")
					.permitAll()
					.anyRequest()
					.authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session -> 
				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.headers(headers -> headers
				.frameOptions(frameOptions -> frameOptions.sameOrigin()))
			.build();
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authManager(
			AuthenticationConfiguration config
	) throws Exception {
		return config.getAuthenticationManager();
	}
}
