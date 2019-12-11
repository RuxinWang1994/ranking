package com.example.ranking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.example.ranking.model.employee;

public class employees {
	private HashMap<Integer, employee> employeeMap;
	
	
	public HashMap<Integer, employee> getEmployeeMap(){
		if (employeeMap == null) {
			employeeMap = new HashMap<>();
		}
		return employeeMap;
	}
	
	public void setEmployeeList(HashMap<Integer, employee> employeeMap) {
		this.employeeMap = employeeMap;
	}
	
	public employee getById(Integer id) {
		return employeeMap.get(id);
	}
	
	public void deleteAll() {
		employeeMap.clear();
	}
	
	public HashMap<Integer, employee> sort(){
		List<HashMap.Entry<Integer,employee>> list = new ArrayList<HashMap.Entry<Integer, employee>>(employeeMap.entrySet());
		Collections.sort(list,new Comparator<HashMap.Entry<Integer, employee>>(){
			public int compare(HashMap.Entry<Integer, employee>o1, HashMap.Entry<Integer, employee>o2) {
				return o1.getValue().getTime().compareTo(o2.getValue().getTime());
			}
		});		
		return employeeMap;
	}
	

}
