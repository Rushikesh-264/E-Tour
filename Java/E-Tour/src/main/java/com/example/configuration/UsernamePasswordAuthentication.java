//package com.example.configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.example.models.Customer;
//import com.example.services.CustomerServices;
//
//@Component
//public class UsernamePasswordAuthentication implements AuthenticationProvider{
//
//	@Autowired
//	CustomerServices service;
//	
//	@Autowired
//	PasswordEncoder encoder;
//	
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		//AuthenticationManager will intercept and take pass and save in authentication object
//		System.out.println("Hi");
//		String username=authentication.getName();    //extract from authentication object
//		String pass=authentication.getCredentials().toString();
//		
////		List<SimpleGrantedAuthority> authorities= new ArrayList();
//		//List<SimpleGrantedAuthority>= will store the authorities/roles
//		
//		Customer customer=service.getCustomerByEmail(username);    // find my email
//		
//		if(customer==null) {
//			
//				throw new BadCredentialsException("Invalid email");
//		}
//		if(!encoder.matches(pass,customer.getPassword())) {  //password that user inputs and password that comes from db
//			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));      //role of email customer that is coming/going
//			throw new BadCredentialsException("Invalid password");
//			
//		}
////		else {
////			throw new BadCredentialsException("User nt found"+ username);
////		}
////		System.out.println("Successful");
//		    //providermanager wille eraseoff the pwd in the obj of authentication.
//		return new UsernamePasswordAuthenticationToken(username,pass,null);
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//		//will check weather the above authentication will return the object of UsernamePasswordAuthenticationToken
//	}
//	
//}
//
//
//
//
