package com.josonprog.common.expression.operator;

import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

/**
 * Operator Adapter.
 * 
 * @author Joson
 *
 * @param <T>
 */
public abstract class AbstractOperator<T extends Comparable<?>> implements Operator<T>{
	private int operandCount = 0;
	
	private int priority = 9999;

	public AbstractOperator() {
	}

	public AbstractOperator(int operandCount, int priority) {
		this.operandCount = operandCount;
		this.priority = priority;
	}
	
	@Override
	public int getOperandCount() {
		return operandCount;
	}

	protected void setOperandCount(int operandCount) {
		this.operandCount = operandCount;
	}

	@Override
	public int getPriority() {
		return priority;
	}

	protected void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Validate operand's amount and type.
	 * 
	 * @param operands
	 * @exception IllegalArgumentException 
	 */
	protected void prepareOperand(Operand<?>... operands) throws IllegalArgumentException {
		// validate amount of operands.
		if (operands.length != this.operandCount) {
			StringBuffer msg = new StringBuffer();
			msg.append(this.operandCount)
				.append(" operands expected but ").append(operands.length).append(" given.");
			
			throw new IllegalArgumentException(msg.toString());
		}
		
		// validate operands' type.
		if (!this.validateOperandTypes(operands)) {
			throw new IllegalArgumentException("Unexpected operands' type.");
		}
	}
	
	protected boolean validateOperandTypes(Operand<?>...operands) {
		for (int i = 0, len = operands.length; i < len; i++) {
			if (operands[i] == null) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public final Operand<T> operate(Operand<?>... operands)
			throws IllegalArgumentException {
		this.prepareOperand(operands);
		
		T res = this.doOperate(operands);
		
		return Operand.<T>wrap(res);
	}
	

	/**
	 * Inner method for implementation by every final operator class.
	 * Before this method is called, AbstractOperator has validate operands' legality.
	 * 
	 * @param operands
	 * @return
	 */
	protected abstract T doOperate(Operand<?>... operands);
	
	@SuppressWarnings("unchecked")
	protected <K> K getOperand(int i, Operand<?>...operands) {
		return (K) operands[i];
	}
}
