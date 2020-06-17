package com.thbs.springCRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.springCRUD.model.EmployeeEntity;
import com.thbs.springCRUD.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeServiceInterface{
	
	@Autowired
	EmployeeRepository er;

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		
		List<EmployeeEntity> employeeList= er.findAll();
		
		if(employeeList.size() >0)
			return employeeList;
		else
			return new ArrayList<EmployeeEntity>();
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		
		Optional<EmployeeEntity> employee= er.findById(id);
		return employee.get();
	}

	@Override
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
		Optional<EmployeeEntity> employee= er.findById(entity.getId());
		if(employee.isPresent()) {
			EmployeeEntity newEmployee = employee.get();
			newEmployee.setEmail(entity.getEmail());
			newEmployee.setFirstname(entity.getFirstname());
			newEmployee.setLastname(entity.getLastname());
			
			newEmployee=er.save(newEmployee);
			
			return newEmployee;
			
		}
		else
			entity= er.save(entity);
		return entity;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Optional<EmployeeEntity> employee= er.findById(id);
		er.deleteById(id);
		
	}

}
