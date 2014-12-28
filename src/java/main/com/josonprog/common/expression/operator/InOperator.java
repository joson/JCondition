package com.josonprog.common.expression.operator;

import java.util.ArrayList;

import com.josonprog.common.expression.Operand;

public class InOperator extends AbstractOperator<Boolean> {

	public InOperator() {
		super(2, new Class<?>[]{Operand.VAL_TYPE_NULL, ArrayList.class});
	}
	
	

	@Override
	protected boolean validateOperandTypes(Operand operand, int index) {
		switch(index) {
		case 0:
			return super.validateOperandTypes(operand, index);
		case 1:
			return operand.getValue() instanceof ArrayList;
		default:
			return false;
		}
	}


	@Override
	public Boolean operate(Object[] values) {
		Object value = values[0];
		ArrayList<?> optionalList = (ArrayList<?>) values[1];
		
		return optionalList.contains(value);
	}
}
