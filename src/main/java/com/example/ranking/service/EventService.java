package com.example.ranking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.ranking.model.event;
import com.example.ranking.model.repo;

public interface EventService {

	/**
	 * Get Events By Actor Id
	 * 
	 * @param actorId
	 * @return {@link List} of Events
	 */
	event getEventsById(Integer id);

	/**
	 * Save Event
	 * 
	 * @param event
	 * @return {@link Optional}
	 */
	void save(event event);

	/**
	 * Find All Events
	 * 
	 * @return {@link Iterable} of Events
	 */
	repo findAll();

	/**
	 * Delete All Events
	 */
	void deleteAll();
}
