package com.onerivet.model.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//import com.onerivet.entity.Adrress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	
	private int id;
	@Size(min=3,message="FirstName should have at least 3 characters")
	@NotEmpty
	private String fname;
	
	@NotEmpty
	@Size(min=3,message="LastName should have at least 3 characters")
	private String lname;
	
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String password; 
	@NotEmpty
	private String phoneNo;
	@NotEmpty
	private String address;
}
