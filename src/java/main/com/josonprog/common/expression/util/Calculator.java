package com.josonprog.common.expression.util;

import java.lang.reflect.InvocationTargetException;
import com.josonprog.common.expression.Expression;
import com.josonprog.common.expression.ExpressionContext;
import com.josonprog.common.expression.ExpressionElement;
import com.josonprog.common.expression.ExpressionNode;
import com.josonprog.common.expression.IllegalExpressionException;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

public class Calculator {
	public Object calculate(Expression expr, ExpressionContext context) throws InvocationTargetException, IllegalExpressionException {
		/**
		 * Haven't use java.util.Stack cause' thread-safety is unnecessary here.
		 */
		//Stack<Object> stack = new Stack<Object>();
		//List<Object> stack = new LinkedList<Object>();

		ExpressionIterator iter = expr.iterate();
		
		CalculationContext calcContext = new CalculationContext(context);
		
		calcContext.setIterator(iter);
		
		while (iter.hasNext()) {
			
			calcContext.setCurrentNode(iter.next());
			
			this.calculateElement(calcContext);
		}
		
		Object res = calcContext.popCalcStack();
		
		if (calcContext.isStackEmpty()) {
			return res;
		} else {
			throw new IllegalExpressionException("Illegal expression.");
		}
	}
	
	protected void calculateElement(CalculationContext context) 
					throws IllegalExpressionException, InvocationTargetException{

		ExpressionNode node = context.getCurrentNode();
		ExpressionElement elem = node.getElem();
		
		if (elem instanceof Operand) {
			this.calculateOperand((Operand) elem, context);
			
		} else if (elem instanceof Operator) {
			this.calculateOperator((Operator<?>) elem, context);
			
		}
	}
	
	protected void calculateOperator(Operator<?> operator, CalculationContext context)
					throws IllegalExpressionException {
		
		int operandCount = operator.getOperandCount();
		
		Object[] operVals = context.popCalcStack(operandCount);
			
		Object res = operator.operate(operVals);
		
		context.pushCalcStack(res);
	}
	
	protected void calculateOperand(Operand operand, CalculationContext context)
					throws IllegalExpressionException, InvocationTargetException {
		operand.invoke(context);
		
		context.pushCalcStack(operand.getValue());
		
	}
}
