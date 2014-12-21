package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public abstract class BoolOperator extends AbstractOperator<Boolean> {

	public BoolOperator() {
		super();
	}

	public BoolOperator(int operandCount) {
		super(operandCount);
	}

	@Override
	protected boolean validateOperandTypes(Operand<?>... operands) {
		Operand<?> operand;
		
		for (int i = 0, len = operands.length; i < len; i++) {
			operand = operands[i];
			if (operand == null || !Boolean.class.isInstance(operand)) {
				return false;
			}
		}
		return true;
	}
	
}
