package com.josonprog.jcondition.support.sql.interpret;

import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.PropertyVariable;
import com.josonprog.common.expression.Variable;
import com.josonprog.common.expression.interpret.OperandInterpreter;
import com.josonprog.common.expression.operator.IllegalOperandException;

public class PropertyVariableInterpreter implements OperandInterpreter {

	@Override
	public String interpret(Operand operand) throws IllegalOperandException {
		PropertyVariable var = (PropertyVariable) operand;
		
		Variable owner = var.getOwner();
		
		if (!owner.getClass().isAssignableFrom(Variable.class)) {
			throw new IllegalOperandException("Illegal property "+var.getVarName() + " in SQL interpreting.");
		}
		
		return owner.getVarName()+"."+this.getMappedColumnName(var.getPropertyName());
	}
	
	public String getMappedColumnName(String property) {
		String columnName = property;
		
		return columnName;
	}

}
