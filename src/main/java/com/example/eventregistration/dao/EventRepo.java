package com.example.eventregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventregistration.entity.Event;

public interface EventRepo extends JpaRepository<Event, Integer>{
   
}
