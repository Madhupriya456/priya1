package com.wenable.priya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.priya.bean.Token;
import com.wenable.priya.bean.User;

import com.wenable.priya.services.UserService;
import com.wenable.priya.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	UserService service;
	
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody User bean) throws Exception
	{
		boolean wer=service.existsByUsername(bean.getUsername()); 
		User user=service.add(bean,wer);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/login")
	public ResponseEntity<Token> getJwt(@RequestBody User bean) {
	return ResponseEntity.ok(service.getToken(bean));
    }
	
	 @GetMapping("/all")
	 public ResponseEntity<List<User>> getUser()
	  {
		  List<User> user=service.getAll();
		  return ResponseEntity.ok(user);
	  }
	   
	 @GetMapping("/user/{id}")
	 public ResponseEntity<User> getById(@PathVariable String id)
	   {
		   User user=service.getById(id);
		   return ResponseEntity.ok(user);
	   }
	   
	  @PostMapping("/{id}")
	  public ResponseEntity<User> addUserToTrackId(@RequestBody User bean,@PathVariable String id)
	   {
		   User user=service.addUserToTrackId(id,bean);
		   return ResponseEntity.ok(user);
	   }
	  
	  @GetMapping("/{trackId}")
	  public ResponseEntity<List<User>> getByTrackId(@PathVariable String trackId)
	  {
		  List<User> user=service.getByTrackId(trackId);
		   return ResponseEntity.ok(user);
	  }
	  
	  @DeleteMapping("/{id}")
	  public void deleteById(@PathVariable String id)
	   {
		   service.deleteById(id);		  
	   }
	  
	  @PutMapping("/{id}")
	  public ResponseEntity<User> updateUser(@RequestBody User bean,@PathVariable String id)
	  {
		  User user=service.update(id,bean);
		  return ResponseEntity.ok(user);
	  }
}
