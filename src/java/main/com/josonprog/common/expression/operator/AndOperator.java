package com.josonprog.common.expression.operator;

public class AndOperator extends BoolOperator {
	public AndOperator() {
		super(2);
	}

	@Override
	public Boolean operate(Object[] values) {
		return (Boolean) values[0] && (Boolean) values[1];
	}

}
