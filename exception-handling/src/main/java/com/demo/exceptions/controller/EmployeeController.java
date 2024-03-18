package com.demo.exceptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.entity.Employee;
import com.demo.exceptions.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return empService.getList();
	}
	
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return empService.getEmployee(id);
	}

}
