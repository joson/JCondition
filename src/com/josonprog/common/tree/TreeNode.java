package com.josonprog.common.tree;

public interface TreeNode {
	/**
	 * Get parent node.
	 * 
	 * @return parent node. if current is a root node, return null.
	 */
	TreeNode parent();
	
	/**
	 * Get the N'th child.
	 * 
	 * @param i begin with 0.
	 * @return the N'th child.
	 * @exception throws IndexOutOfBoundsException if current node hasn't so more children.
	 */
	TreeNode child(int i) throws IndexOutOfBoundsException;
	
	/**
	 * Get the first child.
	 * 
	 * @return the first child. if current is a leaf node, return null.
	 */
	TreeNode firstChild();
	
	/**
	 * Get the next brother.
	 * 
	 * @return next brother. if current node has no more brother, return null.
	 */
	TreeNode nextBrother();

	/**
	 * Whether it's a root node.
	 * 
	 * @return
	 */
	boolean isRoot();

	/**
	 * Whether it's a leaf node.
	 * 
	 * @return
	 */
	boolean isLeaf();
	
	/**
	 * Whether it has the next brother, which child-index large than current's. 
	 * 
	 * @return
	 */
	boolean hasBrother();

	/**
	 * Get the amount of children.
	 * 
	 * @return
	 */
	int countChildren();

	/**
	 * Get an iterator to traverse the tree.
	 * 
	 * @return
	 */
	TreeIterator iterate();

}
