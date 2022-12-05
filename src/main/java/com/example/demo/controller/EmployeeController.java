package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.EmployeeRequest;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee (@Valid @RequestBody EmployeeRequest employeeRequest){
		
		Employee employee = new Employee(employeeRequest);
		employee = employeeRepository.save(employee);
		
		for (String s : employeeRequest.getDepartment()) {
			Department d = new Department();
			//d.setId(Long.parseLong(s));
			d.setName(s);
			d.setEmployee(employee);
			
			departmentRepository.save(d);
		}
		
		return new ResponseEntity<String>("Record saved successfully", HttpStatus.CREATED);
	}
}
