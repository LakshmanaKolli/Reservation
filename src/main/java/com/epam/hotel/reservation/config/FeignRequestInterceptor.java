package com.epam.hotel.reservation.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignRequestInterceptor implements RequestInterceptor{
	
	private static final String AUTHORIZATION = "Authorization";

	@Override
	public void apply(RequestTemplate template) {
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
	        String token = (String) authentication.getCredentials();
	        template.header(AUTHORIZATION, token);
	    }
	}

}
