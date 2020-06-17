package com.thbs.springCRUD.service;

import java.util.List;

import com.thbs.springCRUD.model.EmployeeEntity;

public interface EmployeeServiceInterface {
	
	public List<EmployeeEntity> getAllEmployees();
	
	public EmployeeEntity getEmployeeById(Long id);
	
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity);
	
	public void deleteEmployeeById(Long id);
}
