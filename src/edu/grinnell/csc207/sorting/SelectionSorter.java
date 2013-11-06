package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Sort using selection sort.
 *
 * @author Samuel A. Rebelsky
 * @author Alex Turner '16
 */
public class SelectionSorter<T> extends SorterBridge<T> {
    /**
     * Sort vals using selection sort.  See Sorter<T> for more details.
     * Note: zeroes Utils.counter before sorting vals.
     * 
     * @invariant For all j,k (0 <= j <= k < i) in [0,i), 
     *  order.compare(vals[j],vals[k]) <= 0
     */
    @Override
    public T[] sorti(T[] vals, Comparator<T> order) {
    	Utils.setCounter(0);
	for (int i = 0; i < vals.length; i++) {
	    Utils.swap(vals, i, indexOfSmallest(vals, order, i, vals.length));
	} // for
	return vals;
    } // sorti(T[], Comparator<T>)

    /**
     * Find the index of a smallest element in positions [lb..ub)
     * of values.
     *
     * @param
     *     values, the array into which we are inserting values.
     * @param
     *     order, the comparator used to determine order.
     * @param
     *     lb, the lower bound of the section to search.
     *     ub, the upper bound of the section to search.
     *     
     * @return
     *     is, the index of a smallest value
     *
     * @pre
     *     0 <= lb,ub <= values.length
     * @pre
     *     order can be compared to any pair of values in values.
     * @post
     *     lb <= is < ub
     * @post
     *     For all j, lb <= j < ub, order.compare(values[i], values[j]) <= 0.
     * @post
     *     values is not mutated
     * @invariant
     *     For any lb <= i < ub, order.compare(vals[is],vals[j]) <= 0 for all
     *      j in [lb,i).
     */
    int indexOfSmallest(T[] vals, Comparator<T> order, int lb, int ub) {
	int is = lb;
	for(int i = lb+1; i < ub; i++) {
	    if (order.compare(vals[is], vals[i]) > 0) {
		is = i;
	    } // if
	} // for
	return is;
    } // indexOfSmallest(T[], Comparator<T>, int, int)

} // SelectionSorter<T>
