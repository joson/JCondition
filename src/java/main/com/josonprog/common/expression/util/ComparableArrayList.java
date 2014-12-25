package com.josonprog.common.expression.util;

import java.util.ArrayList;
import java.util.Iterator;

public class ComparableArrayList<E extends Comparable<E>> extends ArrayList<E> 
		implements Comparable<ComparableArrayList<E>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7239738545779109991L;

	@Override
	public int compareTo(ComparableArrayList<E> o) {
		int res = 0;
		
		Iterator<E> curIter = this.iterator();
		Iterator<E> toIter = o.iterator();
		
		E curElem, toElem;
		while (curIter.hasNext() && toIter.hasNext()) {
			curElem = curIter.next();
			toElem = toIter.next();
			
			res = curElem.compareTo(toElem);
			
			if (res != 0) {
				break;
			}
		}
		
		
		if (res == 0) {
			// if one is longer than other.
			if (curIter.hasNext()) 
				res = 1;
			else if (toIter.hasNext())
				res = -1;
		}
		
		return res;
	}
}
