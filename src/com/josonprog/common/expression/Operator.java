package com.josonprog.common.expression;

/**
 * Operator.
 * 
 * @author Joson
 *
 * @param <T>
 */
public interface Operator<T> extends ExpressionElement {
	/**
	 * Operation.
	 * 
	 * Different operation acquire different amount of operands. For example, 
	 * unitary operation requires only one operand and binary operation required two.
	 * 
	 * Normally, operation implementation class provides specified function for its 
	 * own operation, with accepting strictly matching operands as parameters. 
	 * 
	 * @param operands
	 * @return operation result.
	 * @exception throw this exception if operands' type or amount are illegal.
	 */
	public abstract Operand operate(Operand... operands) throws IllegalArgumentException;

	int getOperandCount();

	int getPriority();
	
}
