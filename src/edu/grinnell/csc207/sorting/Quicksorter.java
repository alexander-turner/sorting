package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Samuel A. Rebelsky
 * @author Alex Turner '16
 */
public class Quicksorter<T> extends SorterBridge<T> {
    /**
     * Sort vals using Quicksort.  See the Sorter<T> interface
     * for additional details.
     */
    @Override
    public T[] sorti(T[] vals, Comparator<T> order) {
	qsort(vals, order, 0, vals.length);
	return vals;
    } // sorti(T[], Comparator<T>)

    /**
     * Sort the elements in positions [lb..ub) using Quicksort.
     */
    public void qsort(T[] vals, Comparator<T> order, int lb, int ub) {
	// One element arrays are sorted.
	if (lb >= ub - 1) {
	    return;
	} else {
	    int mid = partition(vals, order, lb, ub);
	    qsort(vals, order, lb, mid);
	    qsort(vals, order, mid+1, ub);
	} // More than one element
    } // qsort(T[], Comparator<T>, int, int)

    /**
     * Referenced 
     * http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java
     * @author Alex Turner '16
     * @author Evan Manuella '16
     * @param vals
     * @param order
     * @param lb
     * @param ub
     * @return the value from a random index
     */
    int choosePivot(T[] vals, Comparator<T> order, int lb, int ub) {
	return lb+(int)(Math.random()*(ub-lb));
    } // choosePivot(T[],Comparator<T>,int,int)

    /**
     * Pick a random pivot and reorganize the elements in positions 
     * [lb..ub) of vals such that elements smaller than the pivot appear
     * to the left, elements bigger than the pivot appear to the right
     * of the pivot, and the pivot is in the middle.  
     * 
     * @author 
     * 	 Alex Turner '16
     * @author 
     * 	 Evan Manuella '16
     * @param
     *    values, an array.
     * @param
     *    order, a comparator.
     * @param
     *    lb, an integer.
     * @param
     *    ub, an integer.
     * @return
     *    mid, the index of the pivot.
     *
     * @pre
     *    order can be applied to any pair of elements in vals.
     * @pre
     *    0 <= lb < ub < values.length.
     * @post
     *    lb <= mid < ub
     * @post
     *    values[mid] == pivot, for some value pivot
     * @post
     *    For all i, lb <= i < mid, order.compare(values[i],pivot) <= 0
     *    For all i, mid < i < ub, order.compare(pivot, values[i]) < 0
     * @invariant
     *    The processed small elements (all i | T[i] <= pivot) precede any
     *    unprocessed elements . The processed large elements 
     *    (all i | T[i] > pivot) follow the unprocessed elements.
     */
    int partition(T[] vals, Comparator<T> order, int lb, int ub) {
	int mid = choosePivot(vals, order, lb, ub);
	int small = lb+1, large = ub;

	Utils.swap(vals, lb, mid);

	while(small <= large) {
	    if (order.compare(vals[small], vals[lb]) <= 0) {
		small++;
	    } else {
		Utils.swap(vals, small, large--);
	    } // if/else
	} // while

	Utils.swap(vals, lb, mid);
	return mid;
    } // partition(T[],order,lb,ub)
} // Quicksorter<T>
