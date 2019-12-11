package com.example.ranking.dto;


import org.springframework.stereotype.Repository;

import com.example.ranking.model.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class eventsRepo {
	private static repo map = new repo();
	static {
		map.getEventsMap().put(1, new event(1, 18, LocalDateTime.now()));
		map.getEventsMap().put(2, new event(2, 19, LocalDateTime.now()));
		map.getEventsMap().put(3, new event(3, 20, LocalDateTime.now()));
	}

	public repo getAllEvents() {
		List<HashMap.Entry<Integer,event>> list = new ArrayList<HashMap.Entry<Integer, event>>(((Map<Integer, event>) map).entrySet());
		Collections.sort(list,new Comparator<HashMap.Entry<Integer, event>>(){
			public int compare(HashMap.Entry<Integer, event>o1, HashMap.Entry<Integer, event>o2) {
				return o1.getValue().getTime().compareTo(o2.getValue().getTime());
			}
		});
		return map;
	}
	public void addEvent(event event) {
		map.getEventsMap().put(event.getId(), event);
	}
	
	public event getEventById(Integer id) {
		return map.getById(id);
	}
	
	public void deleteAll() {
		map.deleteAll();
	}
	
	public boolean exist(Integer id) {
		return map.exist(id);
	}
}
