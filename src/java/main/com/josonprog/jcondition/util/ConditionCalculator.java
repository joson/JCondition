package com.josonprog.jcondition.util;

import java.util.List;

import com.josonprog.common.expression.ExpressionNode;
import com.josonprog.common.expression.IllegalExpressionException;
import com.josonprog.common.expression.Operator;
import com.josonprog.common.expression.operator.AndOperator;
import com.josonprog.common.expression.operator.BoolOperator;
import com.josonprog.common.expression.operator.OrOperator;
import com.josonprog.common.expression.util.CalculationContext;
import com.josonprog.common.expression.util.Calculator;
import com.josonprog.common.expression.util.ExpressionIterator;

public class ConditionCalculator extends Calculator {
	
	@Override
	protected void calculateOperator(Operator<?> operator, CalculationContext context)
			throws IllegalExpressionException {
		
		super.calculateOperator(operator, context);

		ExpressionNode node = context.getCurrentNode();
		ExpressionNode parent = node.parent();
		Operator<?> parentOper = (Operator<?>) parent.getElem();
		
		// if it's a boolean operation, such as and, or, not.
		if (parentOper instanceof BoolOperator) {
			List<?> calcStack = context.getCalcStack();
			
			Boolean res = (Boolean) calcStack.get(calcStack.size()-1);
			
			// if it's a left operand.
			if (node.hasBrother()) {
				
				// for and-operation: if left operand is false, skip this and-operation then return false;
				// for or-operation: if left operand is true, skip this or-operation then return true;
				if ((parentOper instanceof AndOperator && !res)
						|| (parentOper instanceof OrOperator && res)) {
					
					// skip the parent operation and return the current value.
					skipParentOperation(parent, context.getIterator());
				}
			}
		} 
	}
	
	private void skipParentOperation(ExpressionNode parentNode, ExpressionIterator iter) {
		while(iter.hasNext()) {
			if (iter.next().equals(parentNode)) {
				break;
			}
		}
	}

}
