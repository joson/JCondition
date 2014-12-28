package com.josonprog.common.expression;

import com.josonprog.common.expression.operator.AndOperator;
import com.josonprog.common.expression.operator.EqualOperator;
import com.josonprog.common.expression.operator.GreatEqualOperator;
import com.josonprog.common.expression.operator.GreatThanOperator;
import com.josonprog.common.expression.operator.InOperator;
import com.josonprog.common.expression.operator.LessEqualOperator;
import com.josonprog.common.expression.operator.LessThanOperator;
import com.josonprog.common.expression.operator.LikeOperator;
import com.josonprog.common.expression.operator.NotEqualOperator;
import com.josonprog.common.expression.operator.NotOperator;
import com.josonprog.common.expression.operator.OrOperator;

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
	public Operand operate(Operand... operands) throws IllegalArgumentException;

	/**
	 * Before this method is called, make sure operand values' legality.
	 * 
	 * @param operands
	 * @return
	 */
	public T operate(Object[] operandValues) throws IllegalArgumentException;

	int getOperandCount();

	/**
	 * And operator.
	 */
	public static final Operator<Boolean> AND = new AndOperator();
	
	/**
	 * Or operator.
	 */
	public static final Operator<Boolean> OR = new OrOperator();
	
	/**
	 * Not operator.
	 */
	public static final Operator<Boolean> NOT = new NotOperator();

	/**
	 * Equal operator.
	 */
	public static final Operator<Boolean> EQ = new EqualOperator();

	/**
	 * Not-equal operator.
	 */
	public static final Operator<Boolean> NE = new NotEqualOperator();
	
	/**
	 * Great-than operator.
	 */
	public static final Operator<Boolean> GT = new GreatThanOperator();

	/**
	 * Less-than operator.
	 */
	public static final Operator<Boolean> LT = new LessThanOperator();

	/**
	 * Great-or-equal operator.
	 */
	public static final Operator<Boolean> GE = new GreatEqualOperator();

	/**
	 * Less-or-equal operator.
	 */
	public static final Operator<Boolean> LE = new LessEqualOperator();
	
	/**
	 * Like operator.
	 */
	public static final Operator<Boolean> LIKE = new LikeOperator();
	
	/**
	 * In operator.
	 */
	public static final Operator<Boolean> IN = new InOperator();
	
	
	
}
