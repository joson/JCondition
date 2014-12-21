package com.josonprog.jcondition.support.sql;

import java.util.HashMap;
import java.util.Map;

import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;
import com.josonprog.jcondition.AbstractConditionInterpreter;
import com.josonprog.jcondition.ConditionInterpreter;

public class SqlInterpreter extends AbstractConditionInterpreter implements
		ConditionInterpreter {
	
	private static final Map<String, String> SIGN_MAP = new HashMap<String, String>();
	
	static {
		SIGN_MAP.put(ConditionInterpreter.SIGNKEY_LEFT_BRACKET, "(");
		SIGN_MAP.put(ConditionInterpreter.SIGNKEY_RIGHT_BRACKET, ")");
	}

	@Override
	public String getSign(String key) {
		return SIGN_MAP.get(key);
	}

	@Override
	protected String interpretOperand(Operand<?> operand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String interpretOperator(Operator<?> operator,
			String[] operandDescriptions) {
		// TODO Auto-generated method stub
		return null;
	}

}
