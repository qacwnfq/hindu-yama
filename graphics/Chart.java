package com.qacwnfq.hinduyama.graphics;

import java.util.Arrays;
import java.util.Collections;
import java.io.*;

import org.apache.commons.lang.ArrayUtils;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.SwingWrapper;

// maybe add bin width?
public class Plotter{

   public CategoryChart plot( int min, int max, double[] data ){
      double[] range = new double[max-min+1];
      for(int i=0; i<range.length; ++i){
         range[i] = min+i;
      }
      int height = ( int ) Math.round( 1.1*Collections.max( Arrays.asList( ArrayUtils.toObject( data )  ) ) );
      CategoryChart histogram = new CategoryChart( max-min+1, height );
      histogram.addSeries( "blank", range, data );
      return histogram;
   }

   public void save( CategoryChart histogram, String file ) throws IOException {
      BitmapEncoder.saveBitmap( 
            histogram,
            file,
            BitmapEncoder.BitmapFormat.PNG 
            );
   }

   public void show( CategoryChart histogram ){
      new SwingWrapper( histogram ).displayChart();
   }
}
