package com.sumit.restapi.practice.customexception;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ItemCutsomException extends RuntimeException {

		/**
		 * 
		 */
		@JsonIgnore
		@Override
		public StackTraceElement[] getStackTrace() {
		    return super.getStackTrace();
		}
		private static final long serialVersionUID = 1L;

		public ItemCutsomException() {
			super();
			
		}

		public ItemCutsomException(String message) {
			super(message);
		}

		 @Override
		    public synchronized Throwable fillInStackTrace() {
		        return this;
		    }

		public ItemCutsomException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public ItemCutsomException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public ItemCutsomException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}
		 
		
		
	}

