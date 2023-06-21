package com.onerivet.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onerivet.execption.ResourceNotFoundException;
import com.onerivet.model.entity.Employee;
import com.onerivet.model.payload.EmployeeDto;
import com.onerivet.repository.EmployeeRepository;
import com.onerivet.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addEmployeeDetails(EmployeeDto employeeDto) {
		
		employeeDto.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
		return "Employee Added";
	}
	@Override
	public List<EmployeeDto> getAllEmployeeDetails() {

		List<Employee> listOfAllEmployee = employeeRepository.findAll();

		return listOfAllEmployee.stream().map(this::employeeToEmployeeDto)
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found With This Id="+id));
		
		return employeeToEmployeeDto(employee) ;
	}
	
	@Override
	public EmployeeDto updateEmployeeDetails(int id,EmployeeDto employeeDto) {
		
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found With This Id="+id));
		//employee.setId(employeeDto.getId());
		employee.setFname(employeeDto.getFname());
		employee.setLname(employeeDto.getLname());
		employee.setPhoneNo(employeeDto.getPhoneNo());
		employee.setAddress(employeeDto.getAddress());
		
		Employee newEmployee = employeeRepository.save(employee);
		return employeeToEmployeeDto(newEmployee);
	}

	
	@Override
	public String deleteEmployeeDetails(int id) {
		
		employeeRepository.deleteById(id);
		return "Employee Details Deleted";
	}

	public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		return employee;

	}

	public EmployeeDto employeeToEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}

}
