package com.example.ranking.controller;

import static org.springframework.http.HttpStatus.CREATED;

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

import com.example.ranking.dto.employeeDto;
import com.example.ranking.model.employee;

@RestController
@RequestMapping(value = "/employees")
public class RankingRestController {
	@Autowired
    private employeeDto employeedto;
	
	
	/**
	 * Delete All
	 * 
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(path = "/erase", produces = "application/json")
	public ResponseEntity<Void> deleteAll() {
		employeedto.deleteAll();
		return ResponseEntity.ok().build();
	}
	
	
	/**
	 * Save
	 * 
	 * @return {@link ResponseEntity}
	 */	
	@PostMapping(path = "/employee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody employee employee){
		Integer id  = (employeedto.getAllEmployees().getEmployeeMap().size()+1);
		employee.setId(id);
		employeedto.addEmployee(employee);
		
		return ResponseEntity.status(CREATED).build();
	}
	
	
	/**
	 * Find All
	 * 
	 * @return {@link ResponseEntity} List of Events
	 */
	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<Object> getEmployees() {
		return ResponseEntity.ok().body(employeedto.getAllEmployees());
		
	}
	
	
	/**
	 * Get By Id
	 * 
	 * @return {@link ResponseEntity} List of Events
	 */
	@GetMapping(path = "/employees/employee/{id}", produces = "application/json")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") Long actorId, Integer id) {
		return ResponseEntity.ok().body(employeedto.getEmployeeById(id));
	}
	
	
	/**
	 * Update
	 *
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(path = "/employee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> updateEmployee(@RequestBody employee employee){
		Integer id  = (employeedto.getAllEmployees().getEmployeeMap().size()+1);
		Integer score = employeedto.getAllEmployees().getById(id).getScore();
		if (employee.getScore() < score)
		employee.setScore(score);
		return ResponseEntity.ok().build();
	}
}
