package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public class OrOperator extends BoolOperator {
	public OrOperator() {
		super(2);
	}


	@Override
	protected Boolean doOperate(Operand<?>... operands) {
		return this.<Boolean>getOperand(0, operands) || this.<Boolean>getOperand(1, operands);
	}

}
