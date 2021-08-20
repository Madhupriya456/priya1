package com.wenable.priya.dao.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wenable.priya.bean.User;

public interface UserRepository extends MongoRepository<User, String>{

	boolean existsByUsername(String userName);

	List<User> findBytrackId(String trackId);

	User findByUsernameAndPassword(String username, String password);

}
