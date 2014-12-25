package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public class AndOperator extends BoolOperator {
	public AndOperator() {
		super(2, 11);
	}


	@Override
	protected Boolean doOperate(Operand... operands) {
		return ((Boolean) operands[0].getValue()) && ((Boolean) operands[1].getValue());
	}

}
