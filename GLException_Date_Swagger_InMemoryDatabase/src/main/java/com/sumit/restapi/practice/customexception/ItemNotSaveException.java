package com.sumit.restapi.practice.customexception;

public class ItemNotSaveException extends Exception {

	public ItemNotSaveException() {
		super();
		
	}

	public ItemNotSaveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ItemNotSaveException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemNotSaveException(String message) {
		super(message);
	
	}

	public ItemNotSaveException(Throwable cause) {
		super(cause);
	}

	
	
}
