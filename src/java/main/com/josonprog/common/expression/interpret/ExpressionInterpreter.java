package com.josonprog.common.expression.interpret;

import com.josonprog.common.expression.Expression;
import com.josonprog.jcondition.OperationUnsupportedException;

public interface ExpressionInterpreter<T extends Expression> {

	public String interpret(T condition) throws OperationUnsupportedException;

}
