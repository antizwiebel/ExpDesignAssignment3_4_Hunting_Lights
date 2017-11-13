package expd.gjovik.ntnu.no.hunting_lights.lightpollution;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import expd.gjovik.ntnu.no.hunting_lights.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LightPollutionFragmentStatistics extends Fragment {


    private View mView;

    public LightPollutionFragmentStatistics() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LightPollutionFragment.
     */
    public static LightPollutionFragmentStatistics newInstance() {
        LightPollutionFragmentStatistics fragment = new LightPollutionFragmentStatistics();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_light_pollution_fragment_statistics, container, false);
        // in this example, a LineChart is initialized from xml
        BarChart chart = (BarChart) mView.findViewById(R.id.barChart);
        int[] dataObjects = new int[]{150,119,523,2017, 233};

        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i=0; i<dataObjects.length; i++) {
            // turn your data into Entry objects
            entries.add(new BarEntry(i, dataObjects[i]));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Lightpollution in lux"); // add entries to dataset
        dataSet.setColor(R.color.colorPrimary);
        dataSet.setValueTextSize(11f);
        BarData lineData = new BarData(dataSet);

        final HashMap<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "Gjøvik");
        numMap.put(1, "Ålesund");
        numMap.put(2, "Trondheim");
        numMap.put(3, "Oslo");
        numMap.put(4, "Bergen");

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return numMap.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(11f);
        xAxis.setTextColor(Color.WHITE);
        chart.setFitBars(true);
        chart.setData(lineData);
        chart.setBackgroundColor(Color.parseColor("#8ABFC2"));
        xAxis.setDrawGridLines(false);
        chart.setBorderWidth(3.0f);
        chart.animateXY(1000, 1000);
        Description description = new Description();
        description.setText("Light pollution in lux");
        description.setTextSize(22);
        description.setTextColor(Color.WHITE);
        description.setPosition(650,100);
        chart.setDescription(description);
        chart.invalidate(); // refresh
        return mView;
    }

}
