package statistics;

import org.junit.Test;

import java.util.TreeMap;

import static junit.framework.Assert.assertEquals;


/**
 * Created by fredrik on 5/28/17.
 */

public class TestHistogram {
    @Test
    public void histogramValidator_CorrectAbsBins_ReturnsTrue(){
        TreeMap<String, Integer> expected = new TreeMap<String, Integer>();
        expected.put( "2", 4 );
        expected.put( "3", 1 );
        expected.put( "4", 2 );
        expected.put( "5", 1 );
        Integer[] data = new Integer[] {2, 3, 4, 5, 2, 2, 2, 4};
        Histogram hist;
        hist = new Histogram( data );
        TreeMap<String, Integer> actual = hist.getAbsBinsMap();
        assertEquals( expected, actual );
    }
    @Test
    public void histogramValidator_CorrectRelBins_ReturnsTrue(){
        TreeMap<String, Double> expected = new TreeMap<String, Double>();
        expected.put( "2", 0.5 );
        expected.put( "3", 0.125 );
        expected.put( "4", 0.25 );
        expected.put( "5", 0.125 );
        Integer[] data = new Integer[] {2, 3, 4, 5, 2, 2, 2, 4};
        Histogram hist;
        hist = new Histogram( data );
        TreeMap<String, Double> actual = hist.getRelBinsMap();
        assertEquals( expected, actual );
     }
 }




