package com.josonprog.common.expression.operator;

public abstract class CompareOperator extends AbstractOperator<Boolean> {

	public CompareOperator(int priority) {
		super(2, priority);
	}
}
