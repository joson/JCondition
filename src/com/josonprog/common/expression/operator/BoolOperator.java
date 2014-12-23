package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public abstract class BoolOperator extends AbstractOperator<Boolean> {

	public BoolOperator() {
		super();
	}

	public BoolOperator(int operandCount, int priority) {
		super(operandCount, priority);
	}

	@Override
	protected boolean validateOperandTypes(Operand<?>... operands) {
		Operand<?> operand;
		
		for (int i = 0, len = operands.length; i < len; i++) {
			operand = operands[i];
			if (operand == null || !(operand.getValue() instanceof Boolean)) {
				return false;
			}
		}
		return true;
	}
	
}
