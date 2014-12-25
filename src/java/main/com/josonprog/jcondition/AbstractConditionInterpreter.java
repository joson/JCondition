package com.josonprog.jcondition;

import java.util.Stack;

import com.josonprog.common.expression.ExpressionElement;
import com.josonprog.common.expression.ExpressionNode;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;
import com.josonprog.common.expression.operator.IllegalOperandException;

public abstract class AbstractConditionInterpreter implements ConditionInterpreter {
	protected Stack<String> buf = new Stack<String>();

	@Override
	public String interpret(Condition condition) throws OperationUnsupportedException {
		return this.interpretNode(condition.getRoot());
	}

	protected String interpretNode(ExpressionNode expr) throws OperationUnsupportedException {
		Operator<?> rootOper = (Operator<?>) expr.getElem();
		int priority = this.getPriority(rootOper);
		
		int childCount = expr.countChildren();
		
		String[] operandDescs = new String[childCount];

		ExpressionNode child;
		ExpressionElement elem;
		int childPriority;
		for (int i = 0; i < childCount; i++) {
			child = expr.child(i);
			elem = child.getElem();
			
			if (elem instanceof Operator) {
				childPriority = this.getPriority((Operator<?>) elem);
				
				if (priority <= childPriority) {

					operandDescs[i] = this.getSymbol(SIGNKEY_LEFT_BRACKET)
										+this.interpretNode(child)
										+this.getSymbol(SIGNKEY_RIGHT_BRACKET);
				} else {
					operandDescs[i] = this.interpretNode(child);
				}
				
			} else if (elem instanceof Operand) {
				operandDescs[i] = this.interpretOperand((Operand) elem);
			}
		}
		
		return this.interpretOperation(rootOper, operandDescs);
	}
	

	protected abstract String interpretOperand(Operand operand) throws IllegalOperandException;
	
	protected abstract String interpretOperation(Operator<?> operator, String[] operandDescriptions) throws OperationUnsupportedException;
	

}
