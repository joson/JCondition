package com.josonprog.common.expression.operator;

import org.apache.commons.lang.ObjectUtils;

import com.josonprog.common.expression.Operand;

public abstract class CompareOperator extends AbstractOperator<Boolean> {

	public CompareOperator(int priority) {
		super(2, priority);
	}
	
	

	@Override
	protected boolean validateOperandTypes(Operand... operands) {
		Operand operand;
		for (int i = 0, len = operands.length; i < len; i++) {
			operand = operands[i];
			
			if (operand == null || 
					(operand.getValueType() != null && operand.getValue() instanceof Comparable)) {
				return false;
			}
		}
		
		return true;
	}



	@Override
	protected Boolean doOperate(Operand... operands) {
		// TODO Auto-generated method stub
		return null;
	}



	public static int compareTo(Operand o1, Operand o2) throws ClassCastException {
		Comparable<?> value1 = (Comparable<?>) o1.getValue();
		Comparable<?> value2 = (Comparable<?>) o2.getValue();
		
		return ObjectUtils.compare(value1, value2);
	}
	
	
	
}
