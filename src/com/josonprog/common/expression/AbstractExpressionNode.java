package com.josonprog.common.expression;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractExpressionNode implements ExpressionNode {
	private ExpressionElement elem;
	
	private WeakReference<ExpressionNode> parent = null;
	
	private int index = -1;
	
	private List<ExpressionNode> children = new LinkedList<ExpressionNode>();
	
	public AbstractExpressionNode() {}
	
	public AbstractExpressionNode(ExpressionNode parent, int index) {
		this.setParent(parent);
		
		this.setIndex(index);
	}

	@Override
	public ExpressionElement getElem() {
		return elem;
	}

	@Override
	public void setElem(ExpressionElement elem) {
		this.elem = elem;
	}

	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public ExpressionNode parent() {
		return this.parent.get();
	}

	@Override
	public ExpressionNode child(int i) {
		return this.children.get(i);
	}

	@Override
	public ExpressionNode firstChild() {
		return this.children.size() > 0 ? this.children.get(0) : null;
	}

	@Override
	public ExpressionNode nextBrother() {
		if (this.hasBrother()) {
			return this.parent().child(this.index+1);
		} else {
			return null;
		}
	}

	@Override
	public boolean isRoot() {
		return this.index < 0;
	}

	@Override
	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	@Override
	public boolean hasBrother() {
		return this.parent().countChildren() > this.index+1;
	}

	@Override
	public int countChildren() {
		return this.children.size();
	}
	
	/**
	 * Get a tree iterator. 
	 * For expression traversal, Post-order iterator is used.
	 * 
	 * @return Tree iterator.
	 */
	@Override
	public ExpressionIterator iterate() {
		return new ExpressionIterator(this);
	}

	@Override
	public synchronized void addChild(ExpressionNode child) {
		child.setParent(this);
		child.setIndex(this.children.size());
		
		this.children.add(child);
	}

	@Override
	public void setParent(ExpressionNode parent) {
		this.parent.clear();
		
		this.parent = new WeakReference<ExpressionNode>(parent);
	}
	
	
}
