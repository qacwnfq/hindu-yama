package com.qacwnfq.hinduyama.graphics;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestPlotter 
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestPlotter( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( TestPlotter.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPlotter() {
        assertTrue( true );
    }
}
