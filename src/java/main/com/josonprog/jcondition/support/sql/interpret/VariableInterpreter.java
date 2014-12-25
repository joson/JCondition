package com.josonprog.jcondition.support.sql.interpret;

import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.Variable;
import com.josonprog.common.expression.interpret.OperandInterpreter;
import com.josonprog.common.expression.operator.IllegalOperandException;

public class VariableInterpreter implements OperandInterpreter {

	@Override
	public String interpret(Operand operand) throws IllegalOperandException {
		Variable var = (Variable) operand;
		
		return var.getVarName();
	}

}
