package com.qacwnfq.hinduyama;
import junit.framework.TestCase;
import java.util.Arrays;
//import com.qacwnfq.hinduyama.Hinduyama;

public class TestJunit extends TestCase { 
   double[] expected = new double[]{.3,.1,.1,.1,.1,.1,.1,.1,0.,.0,.0};
   int[] arr = new int[]{2,3,4,5,6,7,8,9,2,2};
   public void testHinduYama(){
      double[] result = Hinduyama.histogram( arr );
      assertTrue( Arrays.equals( result, expected ) );
   }
}
