package com.josonprog.common.expression.operator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.josonprog.common.expression.Constant;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

/**
 * Operator Adapter.
 * 
 * @author Joson
 *
 * @param <T>
 */
public abstract class AbstractOperator<T> implements Operator<T>{
	/**
	 * Amount of operands required.
	 */
	private int operandCount = 0;
	
	/**
	 * Legal operand types.
	 */
	private Set<Class<?>> operTypeSet = new HashSet<Class<?>>();

	public AbstractOperator() {
	}

	/**
	 * 
	 * @param operandCount Amount of operands required.
	 */
	public AbstractOperator(int operandCount) {
		this.operandCount = operandCount;
	}

	/**
	 * 
	 * @param operandCount Amount of operands required.
	 * @param operTypeSet Legal operand types.
	 */
	public AbstractOperator(int operandCount, Class<?>[] operTypeSet) {
		this.operandCount = operandCount;
		
		Collections.addAll(this.operTypeSet, operTypeSet);
	}
	
	@Override
	public int getOperandCount() {
		return operandCount;
	}

	protected void setOperandCount(int operandCount) {
		this.operandCount = operandCount;
	}

	/**
	 * Validate operand's amount and type.
	 * 
	 * @param operands
	 * @exception IllegalOperandException 
	 */
	protected Object[] prepareOperand(Operand... operands) throws IllegalOperandException {
		// validate amount of operands.
		if (operands.length != this.operandCount) {
			StringBuffer msg = new StringBuffer();
			msg.append(this.operandCount)
				.append(" operands expected but ").append(operands.length).append(" given.");
			
			throw new IllegalOperandException(msg.toString());
		}
		

		// prepare operand values.
		Object[] operVals = new Object[this.operandCount];
		for (int i = 0; i < this.operandCount; i++) {
			// validate operands' type.
			if (this.validateOperandTypes(operands[i], i)) {
				operVals[i] = operands[i].getValue();
			} else {
				throw new IllegalOperandException("Unexpected operands' type:"+operands[i].getValueType());
			}
		}
		
		return operVals;
	}
	
	protected boolean validateOperandTypes(Operand operand, int index) {
		return this.operTypeSet.contains(operand.getValueType());
	}

	@Override
	public final Operand operate(Operand... operands)
			throws IllegalArgumentException {
		Object[] values = this.prepareOperand(operands);
		
		T res = this.operate(values);
		
		return Constant.wrap(res);
	}
}
