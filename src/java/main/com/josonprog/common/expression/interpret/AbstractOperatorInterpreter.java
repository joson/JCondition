package com.josonprog.common.expression.interpret;

public abstract class AbstractOperatorInterpreter implements
		OperatorInterpreter {
	protected int priority;
	
	protected String symbol;
	
	public AbstractOperatorInterpreter() {}
	
	public AbstractOperatorInterpreter(String symbol, int priority) {
		this.symbol = symbol;
		this.priority = priority;
	}
	
	@Override
	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public int getPriority() {
		return this.priority;
	}

}
