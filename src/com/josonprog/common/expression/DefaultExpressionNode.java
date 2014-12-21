package com.josonprog.common.expression;

public class DefaultExpressionNode extends AbstractExpressionNode {
	
	public DefaultExpressionNode(ExpressionElement elem) {
		this.setElem(elem);
	}

	public DefaultExpressionNode(ExpressionNode parent, int index, ExpressionElement elem) {
		super(parent, index);
		
		this.setElem(elem);
	}

	
}
