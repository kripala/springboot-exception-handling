package com.demo.exceptions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private String location;

}
