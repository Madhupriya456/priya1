package com.wenable.priya.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wenable.priya.services.UserService;
import com.wenable.priya.util.JwtUtil;

@Component
public class AuthFilter extends OncePerRequestFilter{
	
	private static final String SECRET_TOKEN ="eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2Mjk3OTIxMjgsInVzZXJJZCI6IjYxMjQ4ZGNmNDFhMTE2NTNhM2EyZDBlOSIsImlhdCI6MTYyOTc4ODUyOCwidXNlcm5hbWUiOiJtaWtlIn0.YuuKeCg-M05pthKQz_N9GrnZM4at2c-OqY4H3KNaEpvPbOxi-cIkA1StrHWW0-X96Gnrlod7X97AMC6gPm5iYA";

	@Autowired
	JwtUtil util;
	
	@Autowired
	UserService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    		throws ServletException, IOException 
	    {
	    	
		    String authorization=request.getHeader("Authorization");
		    		   	          
			String url= request.getRequestURI();
			
			List<String> exemptedList = new ArrayList<String>();
			exemptedList .add("/swagger");
			exemptedList .add("/webjars");
			exemptedList .add("/images");
			exemptedList .add("/v2");
			exemptedList .add("/csrf");
		    exemptedList .add("/signup");
			exemptedList .add("/login");
			
     		boolean isListallowed=false;
			for (String string : exemptedList) 
			{
				if(url.contains(string))
				{
					isListallowed = true;
				}
			}
			
	    	if(isListallowed)
	    	{
	    		filterChain.doFilter(request, response);
	    		response.getStatus();
	    	}
	    	
	    	else
	    	{    		    		
				if(authorization.equals(SECRET_TOKEN))
	    		{
	    			filterChain.doFilter(request, response);
	        		response.getStatus();
	    		}
	    		else
	    		{
	    			System.out.println("access denied");
	    		}
	    	}
	    }		
}
