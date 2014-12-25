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
	}
	
	protected FastMethod getPropertyGetter() {
		String getterName = "get"+Character.toUpperCase(this.propertyName.charAt(0))+this.propertyName.substring(1);
		
		FastClass cls = FastClass.create(this.owner.getValueType());
		
		return cls.getMethod(getterName, new Class<?>[0]);
	}
	
	@Override
	public Object invoke(ExpressionContext context) throws InvocationTargetException {
		Object parentObj = this.owner.invoke(context);
		
		return this.getter.invoke(parentObj, new Object[0]);
	}

}
