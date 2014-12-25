package com.josonprog.jcondition.support.sql.interpret;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.josonprog.common.expression.Constant;
import com.josonprog.common.expression.Operand;
import com.josonprog.common.expression.interpret.OperandInterpreter;
import com.josonprog.common.expression.operator.IllegalOperandException;

public class ConstantInterpreter implements OperandInterpreter {
	private static final String DESC_NULL = "NULL";

	@Override
	public String interpret(Operand operand) throws IllegalOperandException {
		Constant constant = (Constant) operand;
		
		Class<?> type = constant.getValueType();
		
		if (type == null) {
			return DESC_NULL;
			
		} else if (Boolean.class.isAssignableFrom(type)) {
			return this.describeBoolean(constant);
			
		} else if (Number.class.isAssignableFrom(type)) {
			return this.describeNumber(constant);
			
		} else if (String.class.isAssignableFrom(type) || Character.class.isAssignableFrom(type)) {
			return this.describeString(constant);
			
		} else if (Date.class.isAssignableFrom(type)) {
			return this.describeDate(constant);
			
		} else {
			throw new IllegalOperandException("Illegal operand with type "+type+" as SQL constant.");
		}
	}
	
	public String describeBoolean(Constant constant) {
		return constant.getValue().toString();
	}

	public String describeNumber(Constant constant) {
		return String.valueOf(constant.getValue());
	}

	public String describeString(Constant constant) {
		return "'"+constant.getValue()+"'";
	}

	public String describeDate(Constant constant) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.ms");
		String dateStr = format.format(constant.getValue());
		
		StringBuffer buf = new StringBuffer();
		buf.append("to_date('").append(dateStr).append("', 'YYYY-MM-DD HH24:MI:SS.FF')");
		
		return buf.toString();
	}
}
