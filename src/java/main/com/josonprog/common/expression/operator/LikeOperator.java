package com.josonprog.common.expression.operator;

import java.util.regex.Pattern;

import com.josonprog.common.expression.Operand;

public class LikeOperator extends AbstractOperator<Boolean> {

	public LikeOperator() {
		super(2, new Class<?>[]{Operand.VAL_TYPE_NULL, String.class});
	}
	

	@Override
	protected boolean validateOperandTypes(Operand operand, int index) {
		switch(index) {
		case 0:
			return super.validateOperandTypes(operand, index);
		case 1:
			return operand.getValue() instanceof String;
		default:
			return false;
		}
	}
	
	@Override
	public Boolean operate(Object[] values) {
		
		String value = (String) values[0];
		String regex = (String) values[1];
		
		// Null matches nothing.
		if (value == null) 
			return false;
		else
			return Pattern.matches(regex, value);
	}
}
