package com.demo.exceptions.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler() 
    public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorObject error = new ErrorObject();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimesStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(error,HttpStatus.NOT_FOUND);
        
    }
	
	
	@ExceptionHandler() 
    public ResponseEntity<ErrorObject> handleNoDataFoundException(NoDataFoundException ex) {
        ErrorObject error = new ErrorObject();
        error.setStatusCode(HttpStatus.NO_CONTENT.value());
        error.setMessage(ex.getMessage());
        error.setTimesStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(error,HttpStatus.OK);
        
    }

}
