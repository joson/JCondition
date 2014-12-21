package com.josonprog.jcondition;

import com.josonprog.common.expression.Expression;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

public class Condition extends Expression {
	
	public Condition() {
		super();
	}
	
	public Condition(Operator<Boolean> operator, Operand<?>... operands) {
		super(operator, operands);
	}

	public Condition and(Operator<Boolean> operator, Operand<?>... operands) {
		Expression subExpr = new Expression(operator, operands);
		
		this.append(Expression.AND, subExpr);
		
		return this;
	}

	public Condition and(Condition subcondition) {
		this.append(Expression.AND, subcondition);
		
		return this;
	}

	public Condition or(Operator<Boolean> operator, Operand<?>... operands) {
		Expression subExpr = new Expression(operator, operands);
		
		this.append(Expression.OR, subExpr);
		
		return this;
	}

	public Condition or(Condition subcondition) {
		this.append(Expression.OR, subcondition);
		
		return this;
	}

	public Condition not() {
		this.append(Expression.NOT, new Operand[0]);
		
		return this;
	}
}
