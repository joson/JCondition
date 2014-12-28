package com.josonprog.common.expression.operator;

public final class NotOperator extends BoolOperator {

	public NotOperator() {
		super(1);
	}


	@Override
	public Boolean operate(Object[] values) {
		return !((Boolean) values[0]);
	}
}
