package com.josonprog.common.expression;

/**
 * Operand, to wrap operand constant value or variable.
 * 
 * @author Joson
 *
 * @param <T>
 */
public class Operand 
		implements ExpressionElement {
	
	protected Object value;
	
	public Operand() {}
	
	public Operand(Object value) {
		this.value = value;
	}
	
	public Class<?> getValueType() {
		return value == null ? null : value.getClass();
	}
	
	public Object getValue() {
		return value;
	}
	
	/*
	public static Operand wrap(Object value) {
		return new Operand(value);
	}
*/
}
