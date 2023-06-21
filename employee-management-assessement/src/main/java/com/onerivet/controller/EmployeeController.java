package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.payload.AuthRequestDto;
import com.onerivet.model.payload.EmployeeDto;
import com.onerivet.model.response.GenericResponse;
//import com.onerivet.entity.Employee;
//import com.onerivet.payload.EmployeeDto;
import com.onerivet.service.EmployeeService;

@RestController
@RequestMapping("/api/employee-management")

public class EmployeeController {

	
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * @purpose: Add employee
	 * @param: Employeedto
	 * @return: String
	 */
	@PostMapping("/add")
	public GenericResponse<String>  addEmployee(@RequestBody EmployeeDto employeeDto)
	{
		
		GenericResponse<String> genericResponse=new GenericResponse<>(this.employeeService.addEmployeeDetails(employeeDto),null);
		//String addEmployeeDetails = this.employeeService.addEmployeeDetails(employeeDto);
		return genericResponse;
	}
	/**
	 * @purpose: Get employee List
	 * @param: 
	 * @return: List<EmployeeDto>
	 */
	@GetMapping("/get-all-employee")
	public GenericResponse<List<EmployeeDto>>  getAllEmployee()
	{
		 GenericResponse<List<EmployeeDto>> genericResponse=new GenericResponse<>( this.employeeService.getAllEmployeeDetails(),null);
		
		return genericResponse; 
	}
	
	/**
	 * @purpose: Get employee by id
	 * @param: id
	 * @return: EmployeeDto
	 */
	@GetMapping("/get-employee-by-id/{id}")
	public GenericResponse<EmployeeDto>  getById(@PathVariable int id)
	{
		GenericResponse<EmployeeDto> genericResponse=new GenericResponse<> (this.employeeService.getEmployeeById(id),null);
		return genericResponse;
	}
	
	/**
	 * @purpose: Update employee by id
	 * @param: id
	 * @return: EmployeeDto
	 */
	@PutMapping("/update-employee/{id}")
	public GenericResponse<EmployeeDto>  updateById(@PathVariable int id, @RequestBody EmployeeDto employeeDto)
	{
		GenericResponse<EmployeeDto> genericResponse =  new GenericResponse<>( this.employeeService.updateEmployeeDetails(id ,employeeDto),null);
		return genericResponse;
	}
	/**
	 * @purpose: Delete employee by id
	 * @param: id
	 * @return: String
	 */
	@DeleteMapping("/delete-employee/{id}")
	public  GenericResponse<String>  deleteById(@PathVariable int id)
	{
		GenericResponse<String> genericResponse =new GenericResponse<>(employeeService.deleteEmployeeDetails(id),null);
		return genericResponse;
	}
	
	@PostMapping("generatetoken")
	public String getToken(@RequestBody AuthRequestDto authRequestDto)
	{
		return null;
		
	}
	
	
}
