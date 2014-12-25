package com.josonprog.common.expression;

import java.lang.reflect.InvocationTargetException;

public class Variable extends Operand {

	private Class<?> valueType;
	
	private String varName;
	
	public Variable() {}
	
	public Variable(Class<?> type, String name) {
		this.varName = name;
		
		this.valueType = type;
	}
	
	public Object getValue() {
		return value;
	}
	
	protected void setValue(Object value) {
		this.value = value;
	}
	
	@Override
	public Class<?> getValueType() {
		return valueType;
	}
	
	protected void setValueType(Class<?> valueType) {
		this.valueType = valueType;
	}
	
	/**
	 * Invoke the actual value in the specified expression context.
	 * 
	 * @param context
	 * @return
	 * @throws InvocationTargetException
	 */
	public Object invoke(ExpressionContext context) throws InvocationTargetException {
		this.value = context.get(varName);
		return value;
	}
}
