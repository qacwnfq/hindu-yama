package com.qacwnfq.hinduyama.graphics;

import java.util.Arrays;
import java.util.Collections;
import java.io.*;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.SwingWrapper;

// maybe add bin width?
public class Plotter{
   public static void plot( int min, int max, double[] data ){
      double[] range = new double[]{1, 1, 1}; //IntStream.rangeClosed(min, max).toArray();
      int height = 1; //Collections.max( Arrays.asList( ArrayUtils.toObject( data )  ) );
      CategoryChart histogram = new CategoryChart( max-min+1, height );
      histogram.addSeries( "blank", range, data );
      new SwingWrapper( histogram ).displayChart();
      try{
         BitmapEncoder.saveBitmap( 
               histogram,
               "~/samplechart",
               BitmapEncoder.BitmapFormat.PNG 
               );
      }
      catch ( IOException ex) {
         ex.printStackTrace();
      }
   }
}
