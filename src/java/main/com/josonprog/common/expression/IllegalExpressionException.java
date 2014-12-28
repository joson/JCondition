package com.josonprog.common.expression;

public class IllegalExpressionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7578143187517534533L;

	public IllegalExpressionException() {
		super();
	}

	public IllegalExpressionException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalExpressionException(String message) {
		super(message);
	}

}
