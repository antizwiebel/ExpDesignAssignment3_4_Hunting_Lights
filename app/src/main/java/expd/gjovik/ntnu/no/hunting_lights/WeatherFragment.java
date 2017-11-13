package expd.gjovik.ntnu.no.hunting_lights;


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
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private View mView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LightPollutionFragment.
     */
    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        return fragment;
    }

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_weather, container, false);
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
        description.setTextSize(25);
        chart.setDescription(description);

        chart.invalidate(); // refresh
        return mView;
    }

}
