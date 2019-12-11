package com.example.ranking.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ranking.dto.eventsRepo;
import com.example.ranking.service.EventService;
import com.example.ranking.model.event;
import com.example.ranking.model.repo;


@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private eventsRepo eventRepo;
	
	@Override
	public event getEventsById(Integer id) {
			return eventRepo.getEventById(id);
		}

	@Override
	public void save(event event) {
		if (!eventRepo.exist(event.getId())) {
			eventRepo.addEvent(event);
		}
		else {
			if (eventRepo.getEventById(event.getId()).getScore() < event.getScore()) {
				eventRepo.getEventById(event.getId()).setScore(event.getScore());
			}
		}
	}

	@Override
	public repo findAll() {
		return eventRepo.getAllEvents();
	}

	@Override
	public void deleteAll() {
		eventRepo.deleteAll();
	}

}
