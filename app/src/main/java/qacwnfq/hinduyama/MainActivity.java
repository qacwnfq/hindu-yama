package qacwnfq.hinduyama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Integer[] data;
    Double[] bins;
    BarChart histogram;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.histogram = (BarChart) findViewById(R.id.chart);
        this.data = new Integer[] {2, 2, 3, 3, 4, 4, 4, 5, 12};
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
        ArrayList<String> labels = new ArrayList<String>();
        for (Integer i = 2; i < 13; i++) {
            labels.add(i.toString());
        }
        plot();
    }
    public void plot(){
        System.out.println( "PLOTTING" );
        for( int i=0; i<this.bins.length; ++i ){
            this.bins[i] = 0.;
        }
        for (Integer number : this.data) {
            this.bins[number.intValue() -2 ] +=  1.;
        }
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (Integer i = 0; i < this.bins.length; i++) {
            entries.add( new BarEntry(  i, this.bins[i].floatValue() ) );
        }
        BarDataSet dataset = new BarDataSet(entries, "# of occurences");
        BarData bdata = new BarData( dataset );
        histogram.setData(bdata);
    }
    public void sendMessage( View view ) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        System.out.println( message );
        Integer new_val = Integer.valueOf(message);
        if( new_val > 1 && new_val < 13) {
            Integer[] new_data = new Integer[this.data.length + 1];
            for(int i=0; i<this.data.length; ++i) {
                new_data[i] = this.data[i];
            }
            new_data[new_data.length-1] = new_val;
            this.data = new_data;
            this.histogram.clearValues();
            plot();
        }
    }
}
