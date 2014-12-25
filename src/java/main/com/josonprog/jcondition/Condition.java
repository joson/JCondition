package com.josonprog.jcondition;

import com.josonprog.common.expression.Expression;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

/**
 * Condition API.
 * 
 * @author Joson
 *
 */
public class Condition extends Expression {
	
	/*public Condition() {
		super();
	}
	*/
	public Condition(Operator<Boolean> operator, Operand... operands) {
		super(operator, operands);
	}

	public Condition and(Operator<Boolean> operator, Operand... operands) {
		Expression subExpr = new Expression(operator, operands);
		
		this.append(Operator.AND, subExpr);
		
		return this;
	}

	public Condition and(Condition subcondition) {
		this.append(Operator.AND, subcondition);
		
		return this;
	}

	public Condition or(Operator<Boolean> operator, Operand... operands) {
		Expression subExpr = new Expression(operator, operands);
		
		this.append(Operator.OR, subExpr);
		
		return this;
	}

	public Condition or(Condition subcondition) {
		this.append(Operator.OR, subcondition);
		
		return this;
	}

	public Condition not() {
		this.append(Operator.NOT, new Operand[0]);
		
		return this;
	}
}
