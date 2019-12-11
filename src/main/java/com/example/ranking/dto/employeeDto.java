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
public class employeeDto {
	private static employees map = new employees();
	static {
		map.getEmployeeMap().put(1, new employee(1, 18, LocalDateTime.now()));
		map.getEmployeeMap().put(2, new employee(2, 19, LocalDateTime.now()));
		map.getEmployeeMap().put(3, new employee(3, 20, LocalDateTime.now()));
	}

	public employees getAllEmployees() {
		List<HashMap.Entry<Integer,employee>> list = new ArrayList<HashMap.Entry<Integer, employee>>(((Map<Integer, employee>) map).entrySet());
		Collections.sort(list,new Comparator<HashMap.Entry<Integer, employee>>(){
			public int compare(HashMap.Entry<Integer, employee>o1, HashMap.Entry<Integer, employee>o2) {
				return o1.getValue().getTime().compareTo(o2.getValue().getTime());
			}
		});
		return map;
	}
	public void addEmployee(employee employee) {
		map.getEmployeeMap().put(employee.getId(), employee);
	}
	
	public employee getEmployeeById(Integer id) {
		return map.getById(id);
	}
	
	public void deleteAll() {
		map.deleteAll();
	}
	
}
