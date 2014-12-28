package com.josonprog.common.expression;

import java.lang.reflect.InvocationTargetException;

/**
 * Operand, encapsulating a constant value or variable.
 * 
 * @author Joson
 *
 * @param <T>
 */
public class Operand 
		implements ExpressionElement {
	public static final Class<?> VAL_TYPE_NULL = null;
	
	
	protected Object value;
	
	public Operand() {}
	
	public Operand(Object value) {
		this.value = value;
	}
	
	public Class<?> getValueType() {
		return value == null ? VAL_TYPE_NULL : value.getClass();
	}
	
	public Object getValue() {
		return value;
	}

	public void invoke(ExpressionContext context)
			throws InvocationTargetException {
	}
	
	/*
	public static Operand wrap(Object value) {
		return new Operand(value);
	}
*/
}
