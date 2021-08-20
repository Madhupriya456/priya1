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
	
	private static final String SECRET_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2Mjk0NDg3NzIsInVzZXJJZCI6IjYxMWY1YmIyZTc4YjhhMTExMDk4YjdlZCIsImlhdCI6MTYyOTQ0NTE3MiwidXNlcm5hbWUiOiJtYWRodSJ9.7PwdO5Z8-d_ELU3G22eV_qqgqAeL57PYk2y5vY5vE3O5Cunde90UtyuFtCTrhz-5d6kdBgpLJ-vN9ZTJbs24CQ";

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
			exemptedList .add("/key");
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
