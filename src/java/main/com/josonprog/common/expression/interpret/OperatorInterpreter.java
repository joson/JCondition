package com.josonprog.common.expression.interpret;

public interface OperatorInterpreter {
	public String getSymbol();
	
	public String interpret(String... operandDescriptions);
	
	public int getPriority();
}
