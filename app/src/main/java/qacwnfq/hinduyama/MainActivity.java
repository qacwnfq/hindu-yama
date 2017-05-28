package qacwnfq.hinduyama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.HashMap;

//TODO implement calculation to show probability of this outcome for ideal dices
//TODO implement show of number of throws
//TODO implement show of probability of this outcome
//TODO maybe change color

public class MainActivity extends AppCompatActivity {
    Integer[] data;
    Double[] bins;
    BarChart histogram;
    String lastInput = "None";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.histogram = (BarChart) findViewById(R.id.chart);
        this.data = new Integer[] {};
        this.bins = new Double[11];

        final HashMap<Integer, String> numMapo = new HashMap<>();
        for(Integer i=0; i<this.bins.length; i++) {
            Integer inti = i + 2;
            numMapo.put(i, inti.toString());
        }
        XAxis xAxis = histogram.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return numMapo.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis rightAxis = histogram.getAxisRight();
        rightAxis.setEnabled(false);
        ArrayList<String> labels = new ArrayList<String>();
        for (Integer i = 2; i < 13; i++) {
            labels.add(i.toString());
        }
        plot();
    }
    public void updateLastInput(){
        TextView textView = (TextView) findViewById(R.id.TextView2);
        textView.setText( this.lastInput );
    }
    public void plot(){
        for( int i=0; i<this.bins.length; ++i ){
            this.bins[i] = 0.;
        }
        for (Integer number : this.data) {
            this.bins[number.intValue() -2 ] +=  1./this.data.length;
        }
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (Integer i = 0; i < this.bins.length; i++) {
            entries.add( new BarEntry(  i, this.bins[i].floatValue() ) );
        }
        BarDataSet dataset = new BarDataSet(entries, "# of occurences");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData bdata = new BarData( dataset );
        try{
            this.histogram.clearValues();
        }
        catch( Exception e){
            // do nothing if it was np
        }
        histogram.setData(bdata);
        updateLastInput();
    }

    public void send2( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 2;
        this.data = new_data;
        this.lastInput = "2";
        plot();
    }
    public void send3( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 3;
        this.data = new_data;
        this.lastInput = "3";
        plot();
    }
    public void send4( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 4;
        this.data = new_data;
        this.lastInput = "4";
        plot();
    }
    public void send5( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 5;
        this.data = new_data;
        this.lastInput = "5";
        plot();
    }
    public void send6( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 6;
        this.data = new_data;
        this.lastInput = "6";
        plot();
    }
    public void send7( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 7;
        this.data = new_data;
        this.lastInput = "7";
        plot();
    }
    public void send8( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 8;
        this.data = new_data;
        this.lastInput = "8";
        plot();
    }
    public void send9( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 9;
        this.data = new_data;
        this.lastInput = "9";
        plot();
    }
    public void send10( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 10;
        this.data = new_data;
        this.lastInput = "10";
        plot();
    }
    public void send11( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 11;
        this.data = new_data;
        this.lastInput = "11";
        plot();
    }
    public void send12( View view ) {
        Integer[] new_data = new Integer[this.data.length + 1];
        for(int i=0; i<this.data.length; ++i) {
            new_data[i] = this.data[i];
        }
        new_data[new_data.length-1] = 12;
        this.data = new_data;
        this.lastInput = "12";
        plot();
    }
    public void clearAll( View view ){
        this.data = new Integer[]{};
        this.lastInput = "None";
        plot();
    }
    public void clearLast( View view ){
        if(this.data.length>1) {
            Integer[] new_data = new Integer[this.data.length - 1];
            for (int i = 0; i < new_data.length; i++) {
                new_data[i] = this.data[i];
            }
            this.data = new_data;
            this.lastInput = new_data[new_data.length - 1].toString();
            plot();
        }
        else if(this.data.length == 1 ){
            clearAll( view );
        }
    }
}

