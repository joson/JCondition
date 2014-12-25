package com.josonprog.common.expression;

import java.util.HashMap;
import java.util.Map;

public class ExpressionContext {
	private ExpressionContext parent = null;

	private Map<String, Object> attributes = new HashMap<String, Object>();

	private Map<String, Object> valueStack = new HashMap<String, Object>();
	
	public ExpressionContext() {}
	
	public ExpressionContext(ExpressionContext parent) {
		this.parent = parent;
	}
	
	public void put(String name, Object value) {
		this.valueStack.put(name, value);
	}
	
	public Object get(String name) {
		if (this.valueStack.containsKey(name))
			return this.valueStack.get(name);
		else
			return this.parent.get(name);
	}
	
	public void setAttribute(String attributeName, Object value) {
		this.attributes.put(attributeName, value);
	}
	
	public Object getAttribute(String attributeName) {
		if (this.attributes.containsKey(attributeName)) 
			return this.attributes.get(attributeName);
		else
			return this.parent.getAttribute(attributeName);
	}
}
