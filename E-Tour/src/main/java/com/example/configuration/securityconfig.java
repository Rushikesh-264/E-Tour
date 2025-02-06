package com.example.configuration;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.example.Filter.JWTokenGenerationFilter;
import com.example.Filter.JWTokenValidatorFilter;

import jakarta.servlet.http.HttpServletRequest;

import com.example.Filter.JWTokenGenerationFilter;
import com.example.Filter.JWTokenValidatorFilter;

import jakarta.servlet.http.HttpServletRequest;


@Configuration
public class securityconfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
		security.csrf(crf->crf.disable());   //recommended handle
		security.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.NEVER));   //Jsession ID is not created here we will handle our session
		
		security.addFilterAfter(new JWTokenGenerationFilter(),BasicAuthenticationFilter.class);
		security.addFilterBefore(new JWTokenValidatorFilter(),BasicAuthenticationFilter.class);
		
		security.authorizeHttpRequests(Auth->Auth  
				//which requests to be authorized
//				.requestMatchers("/api/signIn").permitAll());
				
				.requestMatchers("/api/customers/signIn").authenticated()
				.requestMatchers("/api/customers/register").permitAll());
//				.requestMatchers("/api/**").hasRole("ADMIN"));    //while in db: ROLE_ADM, "path"= which methods/url
				//.requestMatchers("/**").permitAll());       //permits all 
		security.httpBasic(Customizer.withDefaults());       //
//		security.formLogin(Customizer.withDefaults())    //basic form
		
		security.cors(csr->csr.configurationSource(new CorsConfigurationSource()
				{
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cfg=new CorsConfiguration();
				cfg.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setExposedHeaders(Collections.singletonList("Authorization"));    //sending the token to FE through headers else it wouldnt be seen 
				cfg.setMaxAge(3600L);        //10hrs
				return cfg;
			}
		}));	
		return security.build();
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();     //encryption
	}
}