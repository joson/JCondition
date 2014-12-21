package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public final class NotOperator extends BoolOperator {

	public NotOperator() {
		super(1, 2);
	}


	@Override
	protected Boolean doOperate(Operand<?>... operands) {
		return !this.<Boolean>getOperand(0, operands);
	}
}
