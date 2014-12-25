package com.josonprog.jcondition;

import com.josonprog.common.expression.Operator;
import com.josonprog.common.expression.interpret.ExpressionInterpreter;

/**
 * Super interface for condition expression interpreting.
 * 
 * For supporting types of interpreting, such as SQL, EL.
 * 
 * @author Joson
 *
 */
public interface ConditionInterpreter extends ExpressionInterpreter<Condition> {
	public static final String SIGNKEY_LEFT_BRACKET = "LEFT_BRACKET";
	public static final String SIGNKEY_RIGHT_BRACKET = "RIGHT_BRACKET";
	
	
	public String getSymbol(String key);
	
	public int getPriority(Operator<?> operator) throws OperationUnsupportedException;
	
}
