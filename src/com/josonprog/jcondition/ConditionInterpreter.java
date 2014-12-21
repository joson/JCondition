package com.josonprog.jcondition;

public interface ConditionInterpreter {
	public static final String SIGNKEY_LEFT_BRACKET = "LEFT_BRACKET";
	public static final String SIGNKEY_RIGHT_BRACKET = "RIGHT_BRACKET";
	
	
	public String getSign(String key);
	
	public String interpret(Condition condition);
	
}
