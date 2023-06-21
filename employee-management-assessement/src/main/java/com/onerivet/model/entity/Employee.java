package com.onerivet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name="EmployeeManagement")
	public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="EmployeeId")
		private int id;
		
		@Column(name="FirstName")
		private String fname;
		
		@Column(name="LastName")
		private String lname;
		
		@Column(name="Email")
		private String email;
		
		@Column(name="Password")
		private String password;
		
		@Column(name="PhoneNumber")
		private String phoneNo;
		
		//@OneToOne()
		@Column(name="Address")
		private String address;
		
	}

