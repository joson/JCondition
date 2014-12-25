package com.josonprog.common.expression.operator;

import java.util.regex.Pattern;

import com.josonprog.common.expression.Operand;

public class LikeOperator extends AbstractOperator<Boolean> {

	public LikeOperator() {
		super(2, 7);
	}
	

	@Override
	protected boolean validateOperandTypes(Operand... operands) {
		if (!super.validateOperandTypes(operands))
			return false;
		
		Object value = operands[0].getValue();
		Object regex = operands[1].getValue();

		// The value must be null or a string.
		if (value != null && value instanceof String)
			return false;
		
		// Regular expression could not be null.
		if (regex == null || regex instanceof String)
			return false;
		
		return true;
	}

	@Override
	protected Boolean doOperate(Operand... operands) {
		
		String value = (String) operands[0].getValue();
		String regex = (String) operands[1].getValue();
		
		// Null matches nothing.
		if (value == null) 
			return false;
		
		return Pattern.matches(regex, value);
	}
}
