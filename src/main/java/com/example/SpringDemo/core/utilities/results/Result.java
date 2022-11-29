package com.example.SpringDemo.core.utilities.results;

public class Result {

	private boolean success;
	private String message;
	
	// Constructorlar
	public Result (boolean success) {
		this.success= success;
	}
	public Result (boolean success,String message) {
		this(success);
		this.message=message;
	}
	
	// Getter yazabiliriz.
	public boolean isSuccuess() {
		return this.success;
		}
	public String getMessage() {
		return this.message;
	}
	
}
