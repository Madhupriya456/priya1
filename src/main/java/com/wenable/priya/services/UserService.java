package com.wenable.priya.services;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenable.priya.bean.Token;
import com.wenable.priya.bean.User;
import com.wenable.priya.configuration.RabbitMQConfig;
import com.wenable.priya.dao.UserDao;
import com.wenable.priya.util.JwtUtil;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	RabbitTemplate template;

	public User add(User bean,boolean wer) throws Exception {
			User user=null;
			if(bean.getPassword()==null)
			{
				throw new Exception("password cant be null");
			}
			if(bean.getUsername()==null)
			{
				throw new Exception("username cant be null");
			}
			if(wer)
			{
				throw new Exception("username already exist");
			}
			else
			{
				user=dao.add(bean);	
			}
			template.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.QUEUE,bean.getMessage());
			return user;	 
		}
	    
	public boolean existsByUsername(String username) {
			return dao.existsByUsername(username);
		}

	public Token getToken(User bean) {
		User user = dao.getByUsernameAndPassword(bean.getUsername(), bean.getPassword());	
			Token resp = new Token();
			if (user == null) {
				resp.setToken("Please signup first");
			} else {
				resp.setToken(util.getToken(user));
			}
	       
		   return resp;
		}
	    	
	public List<User> getAll() {
			
			return dao.getAll();
		}
	    
	public User getById(String id) {		
			return dao.getById(id);
		}
	    
    public User addUserToTrackId(String id, User bean) 
		{
		   User user=getById(id);
		   if(user.getTrackId()!=null)
			{
				System.out.println("trackid already exist");
			}
			else
			{
				user.setTrackId(bean.getTrackId());
			}
				return dao.add(user);
		}

	public List<User> getByTrackId(String trackId) {			
			return dao.getByTrackId(trackId);
		}

	public void deleteById(String id) {
			dao.deleteById(id);	
		}

	public User update(String id, User bean) {
			User user=getById(id);
			if(user!=null)
			{
				if(bean.getPassword()!=null)
				{
					user.setPassword(bean.getPassword());
				}
				if(bean.getMessage()!=null)
				{
					user.setMessage(bean.getMessage());
				}
			}
			return dao.add(user);			
		}

}
