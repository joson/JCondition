package com.josonprog.common.expression;

public class Constant extends Operand {
	public static final Constant NULL = new Constant(null);
	
	private Class<?> type = VAL_TYPE_NULL;
	
	public Constant(Object value) {
		this.value = value;
		
		if (value != null)
			this.type = value.getClass();
	}
	
	public Class<?> getValueType() {
		return type;
	}
	
	public static Constant wrap(Object value) {
		if (value == null) {
			return NULL;
			
		} else {
			return new Constant(value);
			
		}
	}
	
}
