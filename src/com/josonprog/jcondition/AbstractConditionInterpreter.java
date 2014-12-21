package com.josonprog.jcondition;

import java.util.Stack;

import com.josonprog.common.expression.ExpressionElement;
import com.josonprog.common.expression.ExpressionNode;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;

public abstract class AbstractConditionInterpreter implements ConditionInterpreter {
	protected Stack<String> buf = new Stack<String>();

	@Override
	public String interpret(Condition condition) {
		return this.interpretNode(condition.getRoot());
	}

	protected String interpretNode(ExpressionNode expr) {
		Operator<?> rootOper = (Operator<?>) expr.getElem();
		int priority = rootOper.getPriority();
		
		int childCount = expr.countChildren();
		
		String[] operandDescs = new String[childCount];

		ExpressionNode child;
		ExpressionElement elem;
		int childPriority;
		for (int i = 0; i < childCount; i++) {
			child = expr.child(i);
			elem = child.getElem();
			
			if (Operator.class.isInstance(elem)) {
				childPriority = ((Operator<?>) elem).getPriority();
				
				if (priority <= childPriority) {

					operandDescs[i] = this.getSign(SIGNKEY_LEFT_BRACKET)
										+this.interpretNode(child)
										+this.getSign(SIGNKEY_RIGHT_BRACKET);
				} else {
					operandDescs[i] = this.interpretNode(child);
				}
				
			} else if (Operand.class.isInstance(elem)) {
				operandDescs[i] = this.interpretOperand((Operand<?>) elem);
			}
		}
		
		return this.interpretOperator(rootOper, operandDescs);
	}
	

	protected abstract String interpretOperand(Operand<?> operand);
	
	protected abstract String interpretOperator(Operator<?> operator, String[] operandDescriptions);
	

}
