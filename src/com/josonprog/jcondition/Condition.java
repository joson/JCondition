package com.josonprog.jcondition;

import com.josonprog.common.expression.Expression;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

public class Condition extends Expression {
	
	public Condition() {
		super();
	}
	
	public Condition(Operator<?> operator, Operand<?>... operands) {
		super(operator, operands);
	}

	public Condition and(Operator<?> operator, Operand<?>... operands) {
		Expression subExpr = new Expression(operator, operands);
		
		this.append(Expression.AND, subExpr.getRoot());
		
		return this;
	}

	public Condition and(Condition subcondition) {
		this.append(Expression.AND, subcondition.getRoot());
		
		return this;
	}

	public Condition or(Operator<?> operator, Operand<?>... operands) {
		Expression subExpr = new Expression(operator, operands);
		
		this.append(Expression.OR, subExpr.getRoot());
		
		return this;
	}

	public Condition or(Condition subcondition) {
		this.append(Expression.OR, subcondition.getRoot());
		
		return this;
	}

	public Condition not() {
		this.append(Expression.NOT, new Operand[0]);
		
		return this;
	}
}
