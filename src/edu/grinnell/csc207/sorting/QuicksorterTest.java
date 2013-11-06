package edu.grinnell.csc207.sorting;

import org.junit.Test;

/**
 * Measures the complexity of the Quicksorter algorithm.
 * @author turneral1
 *
 */
public class QuicksorterTest {

    @Test
    public void test() {
        Utils.iExperiments(new Quicksorter<Integer>());
        Utils.sExperiments(new Quicksorter<String>());
    } // test()

} // QuicksorterTest
