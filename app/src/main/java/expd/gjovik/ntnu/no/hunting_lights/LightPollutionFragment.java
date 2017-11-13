package expd.gjovik.ntnu.no.hunting_lights;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LightPollutionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LightPollutionFragment extends Fragment {

    private View mView;
    public LightPollutionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LightPollutionFragment.
     */
    public static LightPollutionFragment newInstance() {
        LightPollutionFragment fragment = new LightPollutionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_light_pollution, container, false);
        // in this example, a LineChart is initialized from xml
        BarChart chart = (BarChart) mView.findViewById(R.id.lineChart);
        int[] dataObjects = new int[]{150,119,523,2017, 233};

        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i=0; i<dataObjects.length; i++) {
            // turn your data into Entry objects
            entries.add(new BarEntry(i, dataObjects[i]));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Temperatures in °C"); // add entries to dataset
        dataSet.setColor(Color.BLUE);

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

        chart.setFitBars(true);
        chart.setData(lineData);
        chart.setBackgroundColor(Color.parseColor("#8ABFC2"));
        xAxis.setDrawGridLines(false);
        chart.setBorderWidth(3.0f);
        chart.animateXY(1000, 1000);
        Description description = new Description();
        description.setText("Light pollution in lux");
        description.setTextSize(25);
        description.setTextColor(Color.WHITE);
        description.setPosition(600,100);
        chart.setDescription(description);
        chart.invalidate(); // refresh
        return mView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
