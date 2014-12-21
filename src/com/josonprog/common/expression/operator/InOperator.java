package com.josonprog.common.expression.operator;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import com.josonprog.common.expression.Operand;

public class InOperator extends AbstractOperator<Boolean> {

	public InOperator() {
		super(2, 7);
	}
	

	@Override
	protected boolean validateOperandTypes(Operand<?>... operands) {
		if (!super.validateOperandTypes(operands))
			return false;
		
		Object optionalList = operands[1].getValue();

		// Regular expression could not be null.
		if (optionalList == null || ArrayList.class.isInstance(optionalList))
			return false;
		
		return true;
	}

	@Override
	protected Boolean doOperate(Operand<?>... operands) {
		
		Object value = operands[0].getValue();
		Object[] optionalList = ((ArrayList<?>) operands[1].getValue()).toArray();
		
		return ArrayUtils.contains(optionalList, value);
	}
}
