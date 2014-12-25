package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public class OrOperator extends BoolOperator {
	public OrOperator() {
		super(2, 12);
	}


	@Override
	protected Boolean doOperate(Operand... operands) {
		return ((Boolean) operands[0].getValue()) || ((Boolean) operands[1].getValue());
	}

}
