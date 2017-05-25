package com.qacwnfq.hinduyama.statistics;
import junit.framework.TestCase;
import java.util.Arrays;

public class TestHistogram extends TestCase { 
   double[] expected = new double[]{.3,.1,.1,.1,.1,.1,.1,.1,0.,.0,.0};
   int[] arr = new int[]{2,3,4,5,6,7,8,9,2,2};
   public void testHistogram(){
      double[] result = Histogram.histogram( arr );
      assertTrue( Arrays.equals( result, expected ) );
   }
}
