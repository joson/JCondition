package com.josonprog.common.expression.util;

import java.util.LinkedList;
import java.util.List;

import com.josonprog.common.expression.ExpressionContext;
import com.josonprog.common.expression.ExpressionNode;

public class CalculationContext extends ExpressionContext {
	/**
	 * Haven't use java.util.Stack cause' thread-safety is unnecessary here.
	 */
	//Stack<Object> stack = new Stack<Object>();
	private final List<Object> calcStack = new LinkedList<Object>();
	
	private ExpressionIterator iterator;
	
	private ExpressionNode currentNode;
	
	
	public CalculationContext(ExpressionContext context) {
		super(context);
	}


	public ExpressionIterator getIterator() {
		return iterator;
	}


	public void setIterator(ExpressionIterator iterator) {
		this.iterator = iterator;
	}


	public ExpressionNode getCurrentNode() {
		return currentNode;
	}


	public void setCurrentNode(ExpressionNode currentNode) {
		this.currentNode = currentNode;
	}
	
	public void pushCalcStack(Object o) {
		this.calcStack.add(o);
	}
	
	public Object popCalcStack() {
		return this.calcStack.remove(this.calcStack.size()-1);
	}
	
	public Object[] popCalcStack(int amount) {

		Object[] arr = new Object[amount];
		
		int len = calcStack.size();
		for (int i = 1; i <= amount; i++) {
			arr[i] = calcStack.remove(len-i);
		}
		
		return arr;
	}
	
	public boolean isStackEmpty() {
		return this.calcStack.isEmpty();
	}
	
	public List<Object> getCalcStack() {
		return this.calcStack;
	}
}
