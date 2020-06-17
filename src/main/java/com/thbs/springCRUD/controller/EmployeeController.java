package com.thbs.springCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.springCRUD.model.EmployeeEntity;
import com.thbs.springCRUD.service.EmployeeServiceImp;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImp esi;
	
	
	/** Get the list of all employee **/
	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
		
		List<EmployeeEntity> list= esi.getAllEmployees();
		
		return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	/** Get the employee details based on the id **/
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id){
		EmployeeEntity en=esi.getEmployeeById(id);
		
		return new ResponseEntity<EmployeeEntity>(en, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	/** Both create or Delete **/
	@PostMapping
	public ResponseEntity<EmployeeEntity> createOrUpdateEployee(@RequestBody EmployeeEntity employee){
		EmployeeEntity en= esi.createOrUpdateEmployee(employee);
		
		return new ResponseEntity<EmployeeEntity>(en, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	/** Delete the employee details **/
	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) {
		esi.deleteEmployeeById(id);
		return HttpStatus.OK;
		
	} 
	
}
