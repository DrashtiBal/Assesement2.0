package com.onerivet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.onerivet.model.entity.Employee;
import com.onerivet.repository.EmployeeRepository;

@Component
public class EmployeeInfoEmployeeDetailsService implements Emplo{

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<Employee> employee = employeeRepository.findByName(username);
	        return employee.map(EmployeeInfoEmployeeDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

	    }
	
	
}
