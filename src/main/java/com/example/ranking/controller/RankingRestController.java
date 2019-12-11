package com.example.ranking.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.example.ranking.service.*;
import com.example.ranking.model.event;
import com.example.ranking.model.repo;

@RestController
public class RankingRestController {
	/*
	@RequestMapping(path ="/hello", produces = "application/json")
    public String hello() {
            
        return "Hello World!";
    }
    */
	@Autowired
	private EventService eventService;

	/**
	 * Delete All Events
	 * 
	 * The service should be able to erase all the events by the DELETE request at
	 * /erase. The HTTP response code should be 200.
	 * 
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping("/erase")
	public ResponseEntity<Void> deleteAllEvents() {
		eventService.deleteAll();
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Save Event
	 * 
	 * The service should be able to add a new event by the POST request at /events.
	 * The event JSON is sent in the request body. If an event with the same id
	 * already exists then the HTTP response code should be 400, otherwise, the
	 * response code should be 201.
	 * 
	 * @param eventDTO
	 * @return {@link ResponseEntity}
	 */
	@PostMapping(path = "/events", consumes = "application/json")
	public ResponseEntity<Void> saveEvent(@RequestBody event event) {
		eventService.save(event);
		return ResponseEntity.status(CREATED).build();
	}
	
	/**
	 * Find All Events
	 * 
	 * The service should be able to return the JSON array of all the events by the
	 * GET request at /events. The HTTP response code should be 200. The JSON array
	 * should be sorted in ascending order by event ID.
	 * 
	 * @return {@link ResponseEntity} List of Events
	 */
	@GetMapping("/events")
	public ResponseEntity<repo> getEvents() {
		repo rp = eventService.findAll();
		return ResponseEntity.ok().body(rp);
	}
	
	/**
	 * Get Events By Id
	 * 
	 * The service should be able to return the JSON array of all the events which
	 * are performed by the actor ID by the GET request at /events/actors/{actorID}.
	 * If the requested actor does not exist then HTTP response code should be 404,
	 * otherwise, the response code should be 200. The JSON array should be sorted
	 * in ascending order by event ID.
	 * 
	 * @param actorId
	 * @return {@link ResponseEntity} List of Events
	 */
	@GetMapping("/events/{id}")
	public ResponseEntity<event> getEventsById(@PathVariable("id") Integer id) {
		event event = eventService.getEventsById(id);
		return ResponseEntity.ok().body(event);
	}

	
}
