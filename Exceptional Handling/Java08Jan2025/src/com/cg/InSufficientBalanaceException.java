package com.cg;

public class InSufficientBalanaceException extends RuntimeException{
	
	private String message;

	public InSufficientBalanaceException(String message) {
		super();
		this.message = message;
	}

	public InSufficientBalanaceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InSufficientBalanaceException [message=" + message + "]";
	}

	
	

}
