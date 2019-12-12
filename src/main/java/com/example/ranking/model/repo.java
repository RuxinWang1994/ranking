package com.example.ranking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class repo {

    private HashMap<Integer, event> eventsMap;
	
	
	public HashMap<Integer, event> getEventsMap(){
		if (eventsMap == null) {
			eventsMap = new HashMap<>();
		}
		return eventsMap;
	}
	
	public void setEventsMap(HashMap<Integer, event> eventsMap) {
		this.eventsMap = eventsMap;
	}
	
	public event getById(Integer id) {
		return eventsMap.get(id);
	}
	
	public void deleteAll() {
		eventsMap.clear();
	}
	public boolean exist(Integer id) {
		return eventsMap.containsKey(id);
	}
	
	public HashMap<Integer, event> getAllEvents() {
		return eventsMap;
	}
	
}
