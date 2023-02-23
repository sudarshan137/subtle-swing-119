package com.exception;

public class NoCriminalFoundException extends Exception {

	public NoCriminalFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "No Criminal Found " + getMessage();
	}
}
