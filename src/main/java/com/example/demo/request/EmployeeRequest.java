package com.example.demo.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequest {
	
	private String name;
	
	private List<String> Department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDepartment() {
		return Department;
	}

	public void setDepartment(List<String> department) {
		Department = department;
	}

}
