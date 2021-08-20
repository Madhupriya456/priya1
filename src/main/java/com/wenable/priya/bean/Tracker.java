package com.wenable.priya.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Tracker {
	
	@Id
    private String trackId;
//	private String latitude;
//	private String longitude;	
	private String place;
	private Date time;
	 
	private String[] location;
	
	
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
//	public String getLatitude() {
//		return latitude;
//	}
//	public void setLatitude(String latitude) {
//		this.latitude = latitude;
//	}
//	public String getLongitude() {
//		return longitude;
//	}
//	public void setLongitude(String longitude) {
//		this.longitude = longitude;
//	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getTime() {
		
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

	Date date= new Date();

}
