package com.qacwnfq.hinduyama.graphics;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.*;

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

   public void testPlotter() {
      double[] data = new double[] {0.1, 0.2, 0.5, 0.3, 0.1};
      CategoryChart histogram = Plotter.plot( 1, 5, data );
      try{
         Plotter.save( histogram, "./target/testchart" );
      }
      catch ( IOException ex ){
         ex.printStackTrace();
      }
   }
}
