package com.onerivet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@SpringBootApplication
@OpenAPIDefinition(info =@Info(title = "EmployeeCrud", description = "EmployeeCrudServices", version = "1.0"))
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class EmployeeManagementAssessementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementAssessementApplication.class, args);
	}

	 @Bean
	    public ModelMapper getModelMapper() {
	        return new ModelMapper();
	    }
}