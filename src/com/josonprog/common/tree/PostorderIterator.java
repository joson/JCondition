package com.josonprog.common.tree;

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
		return this.current.isRoot();
	}

	@Override
	public TreeNode next() {
		if (this.current.hasBrother()) {
			return this.current.nextBrother();
		} else {
			return this.current.parent();
		}
	}
	
}
