package com.wenable.priya.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenable.priya.bean.Tracker;
import com.wenable.priya.dao.TrackerDao;

@Service
public class TrackerService {
	
	@Autowired
	TrackerDao dao;
	
	public Tracker addTrack(Tracker bean) {
		
		return dao.add(bean);
	}
	
	public List<Tracker> getTrack() {
		
		return dao.getAll();
	}

    public Tracker getByTrackId(String trackId) {
		
		return dao.getByTrackId(trackId);
	}	
	
	public Tracker updateTrack(Tracker bean, String trackId) {
		
		Tracker track=getByTrackId(trackId);
		if(track!=null)
		{
			
			if(bean.getPlace()!=null)
				{
				  track.setPlace(bean.getPlace());
				}
			
			if(bean.getLocation()!=null)
			{
				track.setLocation(bean.getLocation());
			}			
		 }		
		return dao.add(track);
	}
	
	public void delete(String trackId) {
		dao.deleteById(trackId);		
	}

}
