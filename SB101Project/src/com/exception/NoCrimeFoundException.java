package com.exception;


public class NoCrimeFoundException extends Exception {

	public NoCrimeFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "No Crime Found " + getMessage();
	}
	
	
}
