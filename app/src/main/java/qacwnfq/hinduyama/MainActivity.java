package qacwnfq.hinduyama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarChart histogram = (BarChart) findViewById(R.id.chart);
        Integer[] data = new Integer[] {2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 8 , 8, 9, 10, 11, 12, 12 };
        Double[] bins = new Double[11];
        for( int i=0; i<bins.length; ++i ){
            bins[i] = 0.;
        }
        for (Integer number : data) {
            bins[number.intValue() -2 ] +=  1.;
        }
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (Integer i = 0; i < bins.length; i++) {
            entries.add( new BarEntry(  i, bins[i].floatValue() ) );
        }
        final HashMap<Integer, String> numMapo = new HashMap<>();
        for(Integer i=0; i<bins.length; i++) {
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
        BarDataSet dataset = new BarDataSet(entries, "# of occurences");
        ArrayList<String> labels = new ArrayList<String>();
        for (Integer i = 2; i < 13; i++) {
            labels.add(i.toString());
        }
        BarData bdata = new BarData( dataset );
        histogram.setData(bdata);
    }
}
