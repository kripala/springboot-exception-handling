package com.demo.exceptions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.exceptions.entity.Employee;
import com.demo.exceptions.global.NoDataFoundException;
import com.demo.exceptions.global.ResourceNotFoundException;


@Service
public class EmployeeService {
	
	private static List<Employee> empList = new ArrayList<>();
	
	static {
		empList.add(new Employee(1,"Emp 1",28,"India"));
		empList.add(new Employee(2,"Emp 2",30,"India"));
		empList.add(new Employee(3,"Emp 3",21,"India"));
		empList.add(new Employee(4,"Emp 4",24,"India"));
		empList.add(new Employee(5,"Emp 5",40,"India"));
	}
	
	public List<Employee> getList(){
		if(empList.size()>0)
			return empList;
		throw new NoDataFoundException("No Employee data found");
	}

	
	public Employee getEmployee(Integer id) {
		Optional<Employee> theEmployee = empList.stream()
												.filter(e -> e.getId()==id)
												.findFirst();
		if(!theEmployee.isPresent()) {
			throw new ResourceNotFoundException("Employee is not found for the id --> "+id);
		}
		return theEmployee.get();
	}
	
}
