package com.josonprog.jcondition.support.sql.interpret;

import com.josonprog.common.expression.interpret.AbstractOperatorInterpreter;
import com.josonprog.common.expression.interpret.OperatorInterpreter;

public abstract class LeftUnitaryOperatorInterpreter extends AbstractOperatorInterpreter
		implements OperatorInterpreter {

	public LeftUnitaryOperatorInterpreter() {
		super();
	}

	public LeftUnitaryOperatorInterpreter(String symbol, int priority) {
		super(symbol, priority);
	}

	@Override
	public String interpret(String... operandDescriptions) {
		StringBuffer buf = new StringBuffer();
		
		buf.append(getSymbol()).append(' ').append(operandDescriptions[0]);
		
		return buf.toString();
	}
	
}
