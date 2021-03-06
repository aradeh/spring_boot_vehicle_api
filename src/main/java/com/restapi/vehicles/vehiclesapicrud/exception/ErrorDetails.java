package com.restapi.vehicles.vehiclesapicrud.exception;

import java.util.Date;

/**
 * The type Error response.
 *
 * @author Harshad
 */

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	/**
	   * Instantiates a new Error response.
	   *
	   * @param timestamp2 the timestamp
	   * @param status the status
	   * @param message2 the message
	   * @param details the details
	   */
	
	public ErrorDetails(Date timestamp2, String message2, String description) {
		// TODO Auto-generated constructor stub
		super();
		this.timestamp = timestamp2;
		this.message = message2;
		this.details = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
