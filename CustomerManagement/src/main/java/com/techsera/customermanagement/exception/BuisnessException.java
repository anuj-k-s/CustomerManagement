package com.techsera.customermanagement.exception;


import java.util.Date;

public class BuisnessException extends RuntimeException {
	private Date timestamp;
	private String message;
	
	public BuisnessException(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	
}

