package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Sort using iterative merge sort.
 *
 * @author Samuel A. Rebelsky
 * @author Alex Turner '16
 */
public class IterativeMergeSorter<T> extends SorterBridge<T> {
    /**
     * Sort vals using iterative merge sort.  See the Sorter<T> interface
     * for additional details.
     * @Invariant
     *   For each (i+1)|size in [0,vals.length), for all j in [i, i+size),
     *    order.compare(vals[i],vals[j]). In other words, all subarrays of vals
     *    of size size are sorted.
     */
    @Override
    public T[] sorti(T[] vals, Comparator<T> order) {
	// reset the counter
	Utils.setCounter(0);
	int size = 1;
	while (size < vals.length) {
	    // Merge neighboring subarrays of size size
	    for(int i = 0; i < vals.length; i+=2*size) {
		T VALS[] = Utils.merge(order, vals, i, i+size-1, vals, i+size, i+2*size);
		
		// Copy the merged array to vals
		for(int j = i; j < VALS.length; j++) {
		    vals[j] = VALS[j];
		} // for
	    } // for
	    // The merged subarrays are now twice as large
	    size *= 2;
	} // while
	System.out.println(Utils.getCounter() + " swaps performed.");
	return vals;
    } // sorti(T[], Comparator<T>)
} // IterativeMergeSorter<T>
