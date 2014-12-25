package com.josonprog.common.expression.operator;

public class IllegalOperandException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2392440289746841230L;

	public IllegalOperandException() {
		super();
	}

	public IllegalOperandException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalOperandException(String message) {
		super(message);
	}
	
}
