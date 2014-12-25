package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public final class GreatEqualOperator extends CompareOperator {

	public GreatEqualOperator() {
		super(6);
	}

	@Override
	protected Boolean doOperate(Operand... operands) {
		// left operand.
		Operand operand1 = operands[0];
		
		// right operand.
		Operand operand2 = operands[1];

		return CompareOperator.compareTo(operand1, operand2) >= 0;
	}
	
}
