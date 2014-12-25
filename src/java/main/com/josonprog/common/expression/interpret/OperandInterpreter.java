package com.josonprog.common.expression.interpret;

import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.operator.IllegalOperandException;

public interface OperandInterpreter {
	public String interpret(Operand operand) throws IllegalOperandException ;
}
