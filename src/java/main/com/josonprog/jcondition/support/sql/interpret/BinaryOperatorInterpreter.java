package com.josonprog.jcondition.support.sql.interpret;

import com.josonprog.common.expression.interpret.AbstractOperatorInterpreter;
import com.josonprog.common.expression.interpret.OperatorInterpreter;

public abstract class BinaryOperatorInterpreter extends AbstractOperatorInterpreter
		implements OperatorInterpreter {
	
	public BinaryOperatorInterpreter() {
		super();
	}
	
	public BinaryOperatorInterpreter(String symbol, int priority) {
		super(symbol, priority);
	}
	
	@Override
	public String interpret(String... operandDescriptions) {
		StringBuffer buf = new StringBuffer();
		
		buf.append(operandDescriptions[0]).append(' ').append(getSymbol()).append(' ').append(operandDescriptions[1]);
		
		return buf.toString();
	}
	
}
