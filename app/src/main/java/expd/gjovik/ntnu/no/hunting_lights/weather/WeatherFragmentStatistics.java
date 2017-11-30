package expd.gjovik.ntnu.no.hunting_lights.weather;


import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import expd.gjovik.ntnu.no.hunting_lights.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragmentStatistics extends Fragment {


    private View mView;

    public WeatherFragmentStatistics() {
        // Required empty public constructor
    }

    public static WeatherFragmentStatistics newInstance() {
        WeatherFragmentStatistics fragment = new WeatherFragmentStatistics();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_weather_fragment_statistics, container, false);
        // in this example, a LineChart is initialized from xml
        LineChart chart = (LineChart) mView.findViewById(R.id.lineChart);
        int[] dataObjects = new int[]{-2,0,1,5,8,4,11,12};

        List<Entry> entries = new ArrayList<Entry>();

        for (int i=0; i<dataObjects.length; i++) {
            // turn your data into Entry objects
            entries.add(new Entry(i, dataObjects[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Temperatures in °C"); // add entries to dataset
        dataSet.setColor(Color.WHITE);
        dataSet.setLineWidth(3.0f);
        dataSet.setValueTextSize(11f);
        //dataSet.setDrawCircleHole(true);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setDrawFilled(true);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        //chart.setGridBackgroundColor(Color.CYAN);
        GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(getContext(), R.drawable.chart_gradient);
        dataSet.setFillDrawable(drawable);

        final HashMap<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "00:00");
        numMap.put(1, "02:00");
        numMap.put(2, "04:00");
        numMap.put(3, "06:00");
        numMap.put(4, "08:00");
        numMap.put(5, "10:00");
        numMap.put(6, "12:00");
        numMap.put(7, "14:00");

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(13);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return numMap.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setBackgroundColor(Color.parseColor("#8ABFC2"));
        chart.setBorderWidth(3.0f);
        chart.animateY(2000);
        Description description = new Description();
        description.setText("Temperatures in °C");
        description.setTextColor(Color.WHITE);
        description.setTextSize(22);
        description.setPosition(650,200);
        chart.setDescription(description);

        chart.invalidate(); // refresh
        return mView;
    }

}
