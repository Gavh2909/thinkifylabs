package com.example.eventregistration.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.eventregistration.entity.Event;


public interface EventService {
    abstract ResponseEntity<String> registerEvemt(Event event);
    
    abstract ResponseEntity<List<Event>> getAllEvents();
    
    abstract ResponseEntity<String> deleteEvent(Integer id);
    
    abstract ResponseEntity<String> updateEvent(Event event);
}
