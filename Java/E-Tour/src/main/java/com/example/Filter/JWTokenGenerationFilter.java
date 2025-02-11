package com.example.Filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.configuration.SecurityConstant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTokenGenerationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();   //securityholder has authentication object(which has all username pass etc) so extract it
		if(authentication!=null) {
			SecretKey key=Keys.hmacShaKeyFor(SecurityConstant.JWT_KEY.getBytes(StandardCharsets.UTF_8));  //generation
			String jwt=Jwts.builder().setIssuer("Etour").setSubject("Jwt Token")   //header details 
					.claim("username",authentication.getName())          //
//					.claim("authorities",populateAuthorities(authentication.getAuthorities()))
					.setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime()+3000000))
					.signWith(key).compact();         //token created by compact
			response.setHeader(SecurityConstant.JWT_HEADER,jwt);       //set in response
		}
		filterChain.doFilter(request, response);
	}      //security may execute filter more than once, hence extend Onceperrequestfilter
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {               ///auth/signIn except this should not filter
		return !request.getServletPath().equals("/api/customers/signIn");
	}
	
//	private String populateAuthorities(Collection<?extends GrantedAuthority> collection) {     //to store the authorities in the form of string
//		List<String> authorities=new ArrayList<>();
//		for(GrantedAuthority authority:collection) {
//			authorities.add(authority.getAuthority());
//		}
//		return String.join(",",authorities);   //multiple authorities to be seperated by , 
//	}
	

}
