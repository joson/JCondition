package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public class AndOperator extends BoolOperator {
	public AndOperator() {
		super(2, 11);
	}


	@Override
	protected Boolean doOperate(Operand<?>... operands) {
		return this.<Boolean>getOperand(0, operands) && this.<Boolean>getOperand(1, operands);
	}

}
