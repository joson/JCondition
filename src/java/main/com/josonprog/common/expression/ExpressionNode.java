package com.josonprog.common.expression;

import com.josonprog.common.expression.util.ExpressionIterator;
import com.josonprog.common.tree.TreeNode;

public interface ExpressionNode extends TreeNode {

	@Override
	ExpressionNode parent();

	@Override
	ExpressionNode child(int i);

	@Override
	ExpressionNode firstChild();

	@Override
	ExpressionNode nextBrother();

	@Override
	ExpressionIterator iterate();

	/**
	 * Append an expression node as child.
	 * 
	 * @param child 
	 */
	void addChild(ExpressionNode child);

	void setIndex(int index);
	
	int getIndex();

	ExpressionElement getElem();

	void setElem(ExpressionElement elem);
	
	void setParent(ExpressionNode parent);
}
