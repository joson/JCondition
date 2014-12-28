package com.josonprog.common.tree;

import java.util.NoSuchElementException;

public class PostorderIterator implements TreeIterator {
	protected TreeNode current;
	
	public PostorderIterator(TreeNode tree) {
		TreeNode node = tree;
		while (!node.isLeaf()) {
			node = node.firstChild();
		}
		
		this.current = node;
	}

	@Override
	public boolean hasNext() {
		return !this.current.isRoot();
	}

	@Override
	public TreeNode next() {
		TreeNode next;
		if (this.current.hasBrother()) {
			next = this.current.nextBrother();
		} else {
			next = this.current.parent();
		}
		
		if (next == null)
			throw new NoSuchElementException("Iterator hasn't had next node.");
		
		this.current = next;
		
		return next;
	}

	/**
	 * Unsupported yet.
	 */
	@Deprecated
	@Override
	public void remove() {
	}
	
}
