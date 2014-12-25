package com.josonprog.common.expression.util;

import com.josonprog.common.expression.ExpressionElement;
import com.josonprog.common.expression.ExpressionNode;
import com.josonprog.common.tree.PostorderIterator;
import com.josonprog.common.tree.TreeIterator;

public class ExpressionIterator extends PostorderIterator implements
		TreeIterator {

	public ExpressionIterator(ExpressionNode tree) {
		super(tree);
	}

	@Override
	public ExpressionNode next() {
		return (ExpressionNode) super.next();
	}

	public ExpressionElement nextElement() {
		return this.next().getElem();
	}
}
