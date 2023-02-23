package com.exception;

public class NoRecordFoundException extends Exception {

	public NoRecordFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "No Record Found " + getMessage();
	}
	
}
