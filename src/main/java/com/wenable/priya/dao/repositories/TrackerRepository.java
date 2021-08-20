package com.wenable.priya.dao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wenable.priya.bean.Tracker;

public interface TrackerRepository extends MongoRepository<Tracker, String>{

}
