package com.demo.exceptions.global;

import lombok.Data;

@Data
public class ErrorObject {
	
	private Integer statusCode;
	
	private String message;
	
	private long timesStamp;

}
