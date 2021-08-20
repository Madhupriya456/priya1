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

import com.wenable.priya.bean.Tracker;
import com.wenable.priya.services.TrackerService;

@RestController
@RequestMapping("/track")
public class TrackController {

	@Autowired
	TrackerService service;
	
	@PostMapping("/signup")
	public ResponseEntity<Tracker> addTrack(@RequestBody Tracker bean)
	{
		Tracker track=service.addTrack(bean);
		return ResponseEntity.ok(track);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Tracker>> getTrack()
	{
		List<Tracker> track=service.getTrack();
		return ResponseEntity.ok(track);
	}
	
	@GetMapping("/{trackId}")
	public ResponseEntity<Tracker> getByTrackId(@PathVariable String trackId)
	{
		Tracker track=service.getByTrackId(trackId);
		return ResponseEntity.ok(track);
	}

	@PutMapping("/{trackId}")
	public ResponseEntity<Tracker> updateTrack(@RequestBody Tracker bean,@PathVariable String trackId)
	{
		Tracker track=service.updateTrack(bean,trackId);
		return ResponseEntity.ok(track);
	}
	
	@DeleteMapping("/{trackId}")
	public void deletetrack (@PathVariable String trackId)
	{
		service.delete(trackId);
	}
}
