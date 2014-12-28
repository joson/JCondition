package com.josonprog.common.expression.operator;

import org.apache.commons.lang.ObjectUtils;

public final class GreatThanOperator extends CompareOperator {

	@Override
	public Boolean operate(Object[] values) {
		return ObjectUtils.compare((Comparable<?>)values[0], (Comparable<?>)values[1]) > 0;
	}
	
}
