package com.restapi.vehicles.vehiclesapicrud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.restapi.vehicles.vehiclesapicrud.exception.ErrorDetails;

/**
 * The type Global exception handler.
 *
 * @author Harshad
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	   * Resource not found exception response entity.
	   *
	   * @param ex the ex
	   * @param request the request
	   * @return the response entity
	   */
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/**
	   * Global excpetion handler response entity.
	   *
	   * @param ex the ex
	   * @param request the request
	   * @return the response entity
	   */
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(ResourceNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
