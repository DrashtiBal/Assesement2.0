package com.onerivet.service;

import java.util.List;

import com.onerivet.model.payload.EmployeeDto;

//import com.onerivet.payload.EmployeeDto;

public interface EmployeeService {

	public String addEmployeeDetails(EmployeeDto employeeDto);
	
	public List<EmployeeDto> getAllEmployeeDetails();
	
	public EmployeeDto getEmployeeById(int id);
	
	public EmployeeDto updateEmployeeDetails(int id,EmployeeDto EmployeeDto);
	
	public String deleteEmployeeDetails(int id);
	
}
