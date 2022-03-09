package com.sumit.restapi.practice.entity;

import java.time.LocalTime;

public class ItemErrorMessage extends Exception {

	private int status;
	private String message;
	private LocalTime timestamp;
	public ItemErrorMessage(int statusCode, String errorMessage, LocalTime timestamp) {
		super();
		this.status = statusCode;
		this.message = errorMessage;
		this.timestamp = timestamp;
	}
	public int getStatusCode() {
		return status;
	}
	public String getErrorMessage() {
		return message;
	}
	public LocalTime getTimestamp() {
		return timestamp;
	}  
	
	
	
}
