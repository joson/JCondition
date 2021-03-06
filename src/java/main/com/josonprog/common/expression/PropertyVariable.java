package com.josonprog.common.expression;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

public class PropertyVariable extends Variable {
	private Variable owner;
	
	private String propertyName;
	
	private FastMethod getter;

	
	public PropertyVariable(Variable owner, String propertyName) throws ParseException {
		this.owner = owner;
		
		this.propertyName = propertyName;
		
		this.getter = this.getPropertyGetter();
		
		this.setValueType(this.getter.getReturnType());

		String varName = this.owner.getVarName()+"."+this.getPropertyName();
		this.setVarName(varName);
	}
	
	
	
	public Variable getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}


	protected FastMethod getPropertyGetter() {
		String getterName = "get"+Character.toUpperCase(this.propertyName.charAt(0))+this.propertyName.substring(1);
		
		FastClass cls = FastClass.create(this.owner.getValueType());
		
		return cls.getMethod(getterName, new Class<?>[0]);
	}
	
	@Override
	public void invoke(ExpressionContext context) throws InvocationTargetException {
		this.owner.invoke(context);
		
		Object parentObj = this.owner.getValue();
		
		this.value = this.getter.invoke(parentObj, new Object[0]);
	}

}
