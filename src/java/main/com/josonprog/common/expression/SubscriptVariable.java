package com.josonprog.common.expression;

import java.lang.reflect.InvocationTargetException;

/**
 * It means an element of an array variable, described with a subscript index.
 * 
 * For example, a variable {@link Variable} or a propertyVariable {@link PropertyVariable}:
 * 	Student[] students = school.getStudents();
 * that the valueType of students is Student[].
 * then a subscriptVariable:
 *   Student student = students[3];
 * the valueType of student is Student.
 * 
 * 
 * @author Joson
 *
 */
public class SubscriptVariable extends Variable {
	private Variable owner;
	
	private int subscript = -1;
	
	public SubscriptVariable(Variable owner, int subscript) {
		this.owner = owner;
		
		this.subscript = subscript;
		
		
		Class<?> componentType = this.owner.getValueType().getComponentType();
		
		if (componentType == null) {
			throw new IllegalArgumentException("owner is expected to be an array.");
		}
		
		this.setValueType(componentType);
	}

	@Override
	public Object invoke(ExpressionContext context)
			throws InvocationTargetException {
		
		Object[] values = (Object[]) this.owner.invoke(context);
		
		return values[this.subscript];
	}
}
