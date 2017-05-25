package com.qacwnfq.hinduyama;

public class Histogram{
   public static double[]  histogram( int[] arr ){
      double[] bins = new double[ 11 ];
      double sum = 0;
      for( int number: arr ){
         bins[ number-2 ] += 1; 
         sum += 1;
      }
      for( int i = 0; i<bins.length; i++ ){
         bins[i] /= sum;
      }
      return bins;
   }
}
