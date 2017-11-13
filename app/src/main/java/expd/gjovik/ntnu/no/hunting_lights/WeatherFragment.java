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
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
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
        int[] dataObjects = new int[]{-2,0,3,4};

        List<Entry> entries = new ArrayList<Entry>();

        for (int i=0; i<dataObjects.length; i++) {
            // turn your data into Entry objects
            entries.add(new Entry(i, dataObjects[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Temperatures in °C"); // add entries to dataset
        dataSet.setColor(Color.CYAN);
        dataSet.setLineWidth(3.0f);
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.setGridBackgroundColor(Color.WHITE);
        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        chart.setBorderWidth(3.0f);
        chart.animateY(2000);
        Description description = new Description();
        description.setText("Temperatures in °C");
        chart.setDescription(description);
        chart.invalidate(); // refresh
        return mView;
    }

}
