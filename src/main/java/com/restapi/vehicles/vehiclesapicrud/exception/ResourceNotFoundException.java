package com.restapi.vehicles.vehiclesapicrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception.
 *
 * @author Harshad
 */

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class ResourceNotFoundException extends Exception{
	
	private static final long serialversionUID = 1L;

	/**
	   * Instantiates a new Resource not found exception.
	   *
	   * @param message the message
	   */
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
