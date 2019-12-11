package com.example.ranking.controller;

import java.net.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ranking.dto.employeeDto;
import com.example.ranking.model.employee;
import com.example.ranking.model.employees;

@RestController
@RequestMapping(value = "/employees")
public class RankingRestController {
	@Autowired
    private employeeDto employeedto;
	
	@GetMapping(path = "/", produces = "application/json")
	public employees getEmployees() {
		return employeedto.getAllEmployees();
		
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public employee getEmployeeById(Integer id) {
		return employeedto.getEmployeeById(id);
	}
	
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> updateEmployee(@RequestBody employee employee){
		Integer id  = (employeedto.getAllEmployees().getEmployeeMap().size()+1);
		Integer score = employeedto.getAllEmployees().getById(id).getScore();
		if (employee.getScore() < score)
		employee.setScore(score);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody employee employee){
		Integer id  = (employeedto.getAllEmployees().getEmployeeMap().size()+1);
		employee.setId(id);
		employeedto.addEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/erase")
	public void deleteAllEvents() {
		employeedto.deleteAll();
	}
	

}
