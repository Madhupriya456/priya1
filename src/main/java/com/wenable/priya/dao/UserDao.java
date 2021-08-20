package com.wenable.priya.dao;

import java.util.List;

import com.wenable.priya.bean.User;


public interface UserDao {
	
	User add(User bean);
	
	boolean existsByUsername(String userName);
	
	List<User> getAll();

	User getById(String id);

	List<User> getByTrackId(String trackId);

	void deleteById(String id);

	User getByUsernameAndPassword(String username, String password);
}
