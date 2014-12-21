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

public class Expression {
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
	
	
	
	private ExpressionNode root;
	
	public Expression() {}
	
	public Expression(Operator<?> operator, Operand<?>... operands) {
		this.root = this.buildExpNode(operator, operands);
	}
	
	protected ExpressionNode buildExpNode(Operator<?> operator, Operand<?>... operands) {
		ExpressionNode parent = new DefaultExpressionNode(operator);
		
		ExpressionNode child;
		for (int i = 0, len = operands.length; i < len; i++) {
			child = new DefaultExpressionNode(parent, i, operands[i]);
			parent.addChild(child);
		}
		
		return parent;
	}
	
	public void append(Operator<?> operator, Operand<?>... otherOperands) {
		
		ExpressionNode parent = new DefaultExpressionNode(operator);
		
		if(this.root != null) {
			parent.addChild(this.root);
		}

		ExpressionNode child;
		for (int i = 0, len = otherOperands.length; i < len; i++) {
			child = new DefaultExpressionNode(parent, i, otherOperands[i]);
			parent.addChild(child);
		}
		
		this.root = parent;
	}
	
	public void append(Operator<?> operator, ExpressionNode... subExprs) {

		ExpressionNode parent = new DefaultExpressionNode(operator);
		
		if(this.root != null) {
			parent.addChild(this.root);
		}

		ExpressionNode child;
		for (int i = 0, len = subExprs.length; i < len; i++) {
			child = subExprs[i];
			parent.addChild(child);
		}
		
		this.root = parent;
	}

	public ExpressionNode getRoot() {
		return root;
	}

	public void setRoot(ExpressionNode root) {
		this.root = root;
	}
	
	
}
