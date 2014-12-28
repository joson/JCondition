package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;

public abstract class CompareOperator extends AbstractOperator<Boolean> {

	public CompareOperator() {
		super(2, new Class<?>[]{Operand.VAL_TYPE_NULL, Comparable.class});
	}
	
}
