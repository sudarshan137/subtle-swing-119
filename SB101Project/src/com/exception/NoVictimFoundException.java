package com.exception;

public class NoVictimFoundException extends Exception{

	public NoVictimFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "No Victim Found " + getMessage();
	}
}
