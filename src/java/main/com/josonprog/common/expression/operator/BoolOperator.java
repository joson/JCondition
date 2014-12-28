package com.josonprog.common.expression.operator;

public abstract class BoolOperator extends AbstractOperator<Boolean> {

	public BoolOperator() {
		super();
	}

	public BoolOperator(int operandCount) {
		super(operandCount, new Class<?>[]{Boolean.class});
	}
}
