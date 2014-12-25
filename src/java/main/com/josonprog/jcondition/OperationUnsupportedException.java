package com.josonprog.jcondition;

import com.josonprog.common.expression.Operator;

public class OperationUnsupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1183747654147022056L;

	public OperationUnsupportedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationUnsupportedException(Operator<?> operator) {
		super("Unsupported operation in the right context: "+operator.getClass().getName());
	}

}
