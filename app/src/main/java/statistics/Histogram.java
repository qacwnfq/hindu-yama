package statistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by fredrik on 5/27/17.
 */

public class Histogram {
    Integer numEntries;
    Double binwidth;
    Double max;
    Double min;

    Double[] data;
    TreeMap<String, Integer> absBins;
    TreeMap<String, Double> relBins;

    public Histogram( Integer[] data ){
        absBins = new TreeMap<String, Integer>();
        relBins = new TreeMap<String, Double>();
        // basic variables needed
        this.binwidth = 1.;
        this.numEntries = data.length;
        this.min = Double.valueOf( Collections.min( Arrays.asList( data ) ) );
        this.max = Double.valueOf( Collections.max( Arrays.asList( data ) ) );
        // store data
        this.data = new Double[ data.length ];
        for(int i=0; i<data.length; i++) {
            this.data[ i ] = Double.valueOf( data[ i ] );
            Integer absCount = this.absBins.containsKey( data[ i ].toString() ) ? this.absBins.get( data[ i ].toString() ) : 0;
            Double relCount = this.relBins.containsKey( data[ i ].toString() ) ? this.relBins.get( data[ i ].toString() ) : 0;
            this.absBins.put( data[ i ].toString(), absCount+1 );
            this.relBins.put( data[ i ].toString(), relCount+1./ numEntries);
        }
    }

    public Integer getNumEntries() {
        return numEntries;
    }

    public Double getBinwidth() {
        return binwidth;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }

    public Double[] getData() {
        return data;
    }

    public TreeMap<String, Integer> getAbsBins() {
        return absBins;
    }

    public TreeMap<String, Double> getRelBins() {
        return relBins;
    }
};
