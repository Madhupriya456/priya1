package com.wenable.priya.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Tracker {
	
	@Id
    private String trackId;
	private String place;
	private Date time;
	private String[] location;
		
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getTime() {
		Date date= new Date();
		return date;
	}
	public void setTime(Date date) {
		this.time = date;
	}
	
	public String[] getLocation() {
		return location;
	}
	public void setLocation(String[] location) {
		this.location = location;
	}

}
