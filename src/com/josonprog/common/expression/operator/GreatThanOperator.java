package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public final class GreatThanOperator extends CompareOperator {

	public GreatThanOperator() {
		super(6);
	}

	@Override
	protected Boolean doOperate(Operand<?>... operands) {
		// left operand.
		Operand<?> operand1 = this.getOperand(0, operands);
		
		// right operand.
		Operand<?> operand2 = this.getOperand(1, operands);
		
		return operand1.compareTo(operand2) > 0;
	}
	
}
