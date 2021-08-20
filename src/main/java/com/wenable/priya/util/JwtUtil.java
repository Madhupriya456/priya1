package com.wenable.priya.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.wenable.priya.bean.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	
	private static String JWT_SECRET = "Very secret";
	
		private static int JWT_EXPIRY = 60 * 60 * 1000;
	
		public String getToken(User user) {
	
			Date issuedAt = new Date();
	
			Date expiresAt = new Date(issuedAt.getTime() + JWT_EXPIRY);
	
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("userId", user.getId());
			claims.put("username", user.getUsername());
	
			return Jwts.builder().setClaims(claims)
	
					.setIssuedAt(issuedAt).setExpiration(expiresAt).signWith(SignatureAlgorithm.HS512, JWT_SECRET)
					.compact();
}
}