package com.example.eventregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.eventregistration.dao.EventRepo;
import com.example.eventregistration.entity.Event;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo repo;
	
	

	public ResponseEntity<String> registerEvemt(Event event) {
	  Event res =repo.save(event);
	  String response = "Event registered successfully";
	  if(res == null) {
		  response = "Unable to register the event";
	  }
	  
	  return new ResponseEntity<>(response, HttpStatus.OK);
	}



	@Override
	public ResponseEntity<List<Event>> getAllEvents() {
		List<Event> events = repo.findAll();
		return new ResponseEntity<>(events, HttpStatus.OK);
	}



	@Override
	public ResponseEntity<String> deleteEvent(Integer id) {
		repo.deleteById(id);
		return new ResponseEntity<>("Event has been deleted", HttpStatus.OK);
	}



	@Override
	public ResponseEntity<String> updateEvent(Event event) {
		repo.save(event);
		return new ResponseEntity<>("Event has been updates", HttpStatus.OK);
	}

}
