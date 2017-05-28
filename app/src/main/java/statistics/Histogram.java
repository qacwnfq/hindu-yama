package statistics;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
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
    TreeMap<String, Integer> absBinsMap;
    TreeMap<String, Double> relBinsMap;

    ArrayList<BarEntry> absBins = new ArrayList<>();
    ArrayList<BarEntry> relBins = new ArrayList<>();

    BarDataSet absDataSet;
    BarDataSet relDataSet;

    public Histogram( Integer[] data ){
        absBinsMap = new TreeMap<String, Integer>();
        relBinsMap = new TreeMap<String, Double>();
        // basic variables needed
        this.binwidth = 1.;
        this.numEntries = data.length;
        this.min = Double.valueOf( Collections.min( Arrays.asList( data ) ) );
        this.max = Double.valueOf( Collections.max( Arrays.asList( data ) ) );
        // store data
        this.data = new Double[ data.length ];
        for(int i=0; i<data.length; i++) {
            this.data[ i ] = Double.valueOf( data[ i ] );
            Integer absCount = this.absBinsMap.containsKey( data[ i ].toString() ) ? this.absBinsMap.get( data[ i ].toString() ) : 0;
            Double relCount = this.relBinsMap.containsKey( data[ i ].toString() ) ? this.relBinsMap.get( data[ i ].toString() ) : 0;
            this.absBinsMap.put( data[ i ].toString(), absCount+1 );
            this.relBinsMap.put( data[ i ].toString(), relCount+1./ numEntries);
        }
        // convert to format compatible with charts
        for( Map.Entry<String, Integer> entry: absBinsMap.entrySet() ){
            this.absBins.add( new BarEntry( Double.valueOf( entry.getValue() ).floatValue() , Double.valueOf( entry.getKey() ).floatValue() ) );
        }
        for( Map.Entry<String, Double> entry: relBinsMap.entrySet() ){
            this.relBins.add( new BarEntry( Double.valueOf( entry.getValue() ).floatValue() , Double.valueOf( entry.getKey() ).floatValue() ) );
        }
        this.absDataSet = new BarDataSet( absBins, "# of things" );
        this.relDataSet = new BarDataSet( relBins, "# of rel things" );
    }

    public void show(){

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

    public TreeMap<String, Integer> getAbsBinsMap() {
        return absBinsMap;
    }

    public TreeMap<String, Double> getRelBinsMap() {
        return relBinsMap;
    }
};
