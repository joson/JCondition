package com.josonprog.jcondition.support.sql;

import java.util.HashMap;
import java.util.Map;

import com.josonprog.common.expression.Constant;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Operator;
import com.josonprog.common.expression.PropertyVariable;
import com.josonprog.common.expression.Variable;
import com.josonprog.common.expression.interpret.OperandInterpreter;
import com.josonprog.common.expression.interpret.OperatorInterpreter;
import com.josonprog.common.expression.operator.IllegalOperandException;
import com.josonprog.jcondition.AbstractConditionInterpreter;
import com.josonprog.jcondition.ConditionInterpreter;
import com.josonprog.jcondition.OperationUnsupportedException;
import com.josonprog.jcondition.support.sql.interpret.AndInterpreter;
import com.josonprog.jcondition.support.sql.interpret.ConstantInterpreter;
import com.josonprog.jcondition.support.sql.interpret.EqualInterpreter;
import com.josonprog.jcondition.support.sql.interpret.GreatEqualInterpreter;
import com.josonprog.jcondition.support.sql.interpret.GreatThanInterpreter;
import com.josonprog.jcondition.support.sql.interpret.InInterpreter;
import com.josonprog.jcondition.support.sql.interpret.LessEqualInterpreter;
import com.josonprog.jcondition.support.sql.interpret.LessThanInterpreter;
import com.josonprog.jcondition.support.sql.interpret.LikeInterpreter;
import com.josonprog.jcondition.support.sql.interpret.NotEqualInterpreter;
import com.josonprog.jcondition.support.sql.interpret.NotInterpreter;
import com.josonprog.jcondition.support.sql.interpret.OrInterpreter;
import com.josonprog.jcondition.support.sql.interpret.PropertyVariableInterpreter;
import com.josonprog.jcondition.support.sql.interpret.VariableInterpreter;

public class SqlInterpreter extends AbstractConditionInterpreter implements
		ConditionInterpreter {
	private static final Map<Operator<?>, OperatorInterpreter> OPERATOR_INTERPRETER_MAP = new HashMap<Operator<?>, OperatorInterpreter>();
	
	private static final Map<Class<? extends Operand>, OperandInterpreter> OPERAND_INTERPRETER_MAP = new HashMap<Class<? extends Operand>, OperandInterpreter>();
	
	
	private static final Map<String, String> SIGN_MAP = new HashMap<String, String>();
	
	static {
		SIGN_MAP.put(ConditionInterpreter.SIGNKEY_LEFT_BRACKET, "(");
		SIGN_MAP.put(ConditionInterpreter.SIGNKEY_RIGHT_BRACKET, ")");

		OPERATOR_INTERPRETER_MAP.put(Operator.EQ, new EqualInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.NE, new NotEqualInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.GT, new GreatThanInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.GE, new GreatEqualInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.LT, new LessThanInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.LE, new LessEqualInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.NOT, new NotInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.AND, new AndInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.OR, new OrInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.IN, new InInterpreter());
		OPERATOR_INTERPRETER_MAP.put(Operator.LIKE, new LikeInterpreter());

		OPERAND_INTERPRETER_MAP.put(Constant.class, new ConstantInterpreter());
		OPERAND_INTERPRETER_MAP.put(Variable.class, new VariableInterpreter());
		OPERAND_INTERPRETER_MAP.put(PropertyVariable.class, new PropertyVariableInterpreter());
	}

	@Override
	public String getSymbol(String key) {
		return SIGN_MAP.get(key);
	}

	@Override
	public String interpretOperand(Operand operand) throws IllegalOperandException {
		Class<?> type = operand.getClass();
		
		if (!OPERAND_INTERPRETER_MAP.containsKey(type)) {
			throw new IllegalOperandException("Illegal operand type ("+type+") in SQL interpreting.");
		}
		
		return OPERAND_INTERPRETER_MAP.get(type).interpret(operand);
	}

	@Override
	protected String interpretOperation(Operator<?> operator,
			String[] operandDescriptions) throws OperationUnsupportedException {
		if (!OPERATOR_INTERPRETER_MAP.containsKey(operator))
			throw new OperationUnsupportedException(operator);

		return OPERATOR_INTERPRETER_MAP.get(operator).interpret(operandDescriptions);
	}

	@Override
	public int getPriority(Operator<?> operator) throws OperationUnsupportedException {
		if (!OPERATOR_INTERPRETER_MAP.containsKey(operator))
			throw new OperationUnsupportedException(operator);

		return OPERATOR_INTERPRETER_MAP.get(operator).getPriority();
	}
}
