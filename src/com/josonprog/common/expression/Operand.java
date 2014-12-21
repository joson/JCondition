package com.josonprog.common.expression;

import org.apache.commons.lang.ObjectUtils;

/**
 * Operand, to wrap operand constant value or variable.
 * 
 * @author Joson
 *
 * @param <T>
 */
public class Operand<T extends Comparable<?>> 
		implements ExpressionElement, Comparable<Operand<?>> {
	
	protected T value;
	
	public Operand() {}
	
	public Operand(T value) {
		this.value = value;
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getValueType() {
		return value == null ? null : (Class<T>) value.getClass();
	}
	
	public T getValue() {
		return value;
	}
	
	
	public static <K extends Comparable<?>> Operand<K> wrap(K value) {
		return new Operand<K>(value);
	}

	@Override
	public int compareTo(Operand<?> o) {
		return ObjectUtils.compare(this.getValue(), o.getValue());
	}
	
}
