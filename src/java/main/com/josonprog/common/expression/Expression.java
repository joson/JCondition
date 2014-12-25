package com.josonprog.common.expression;

import com.josonprog.common.expression.util.ExpressionIterator;

public class Expression {
	
	private ExpressionNode root;
	
	public Expression() {}
	
	public Expression(Operator<?> operator, Operand... operands) {
		this.root = this.buildExpNode(operator, operands);
	}
	
	protected ExpressionNode buildExpNode(Operator<?> operator, Operand... operands) {
		ExpressionNode parent = new DefaultExpressionNode(operator);
		
		ExpressionNode child;
		for (int i = 0, len = operands.length; i < len; i++) {
			child = new DefaultExpressionNode(parent, i, operands[i]);
			parent.addChild(child);
		}
		
		return parent;
	}
	
	public void append(Operator<?> operator, Operand... otherOperands) {
		
		ExpressionNode parent = new DefaultExpressionNode(operator);
		
		if(this.root != null) {
			parent.addChild(this.root);
		}

		ExpressionNode child;
		for (int i = 0, len = otherOperands.length; i < len; i++) {
			child = new DefaultExpressionNode(parent, i, otherOperands[i]);
			parent.addChild(child);
		}
		
		this.root = parent;
	}
	
	public void append(Operator<?> operator, Expression... subExprs) {

		ExpressionNode parent = new DefaultExpressionNode(operator);
		
		if(this.root != null) {
			parent.addChild(this.root);
		}

		ExpressionNode child;
		for (int i = 0, len = subExprs.length; i < len; i++) {
			child = subExprs[i].getRoot();
			parent.addChild(child);
		}
		
		this.root = parent;
	}

	public ExpressionNode getRoot() {
		return root;
	}

	public void setRoot(ExpressionNode root) {
		this.root = root;
	}
	
	public ExpressionIterator iterate() {
		return this.root.iterate();
	}
}
