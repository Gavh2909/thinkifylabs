package com.example.eventregistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventregistration.dao.EventRepo;
import com.example.eventregistration.entity.Event;
import com.example.eventregistration.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService service;

	@Autowired
	private EventRepo repo;

	@PostMapping("/new")
	public ResponseEntity<String> registerEvent(@RequestBody Event event) {

		return service.registerEvemt(event);
	}

	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {
		return service.getAllEvents();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable Integer id) {
		return service.deleteEvent(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEvent(@PathVariable Integer id, @RequestBody Event updatedEvent) {
		Optional<Event> optionalEvent = repo.findById(id);

		if (optionalEvent.isPresent()) {
			Event existingEvent = optionalEvent.get();

			if (updatedEvent.getName() != null) {
				existingEvent.setName(updatedEvent.getName());
			}
			if (updatedEvent.getLocation() != null) {
				existingEvent.setLocation(updatedEvent.getLocation());
			}
			if (updatedEvent.getDate() != null) {
				existingEvent.setDate(updatedEvent.getDate());
			}
			if (updatedEvent.getRegistrationDetails() != null) {
				existingEvent.setRegistrationDetails(updatedEvent.getRegistrationDetails());
			}
			return service.updateEvent(existingEvent);
		}

		return null;
	}

}
