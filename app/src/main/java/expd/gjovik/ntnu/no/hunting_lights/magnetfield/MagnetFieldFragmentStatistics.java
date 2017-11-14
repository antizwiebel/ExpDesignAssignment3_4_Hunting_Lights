package expd.gjovik.ntnu.no.hunting_lights.magnetfield;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
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
 * Use the {@link MagnetFieldFragmentStatistics#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagnetFieldFragmentStatistics extends Fragment {


    private View mView;

    public MagnetFieldFragmentStatistics() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MagnetFieldFragmentStatistics newInstance() {
        MagnetFieldFragmentStatistics fragment = new MagnetFieldFragmentStatistics();
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

        mView = inflater.inflate(R.layout.fragment_magnet_field_fragment_statistics, container, false);
        // in this example, a LineChart is initialized from xml
        HorizontalBarChart chart = (HorizontalBarChart) mView.findViewById(R.id.horBarChart);
        int[] dataObjects = new int[]{20,25,27,30};

        final ArrayList<String> labels = new ArrayList<String>();
        labels.add("now");
        labels.add("15 min");
        labels.add("30 min");
        labels.add("45 min");

        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i=0; i<dataObjects.length; i++) {
            // turn your data into Entry objects
            entries.add(new BarEntry(i, dataObjects[i], labels.get(i)));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Magnetfield in ?"); // add entries to dataset
        dataSet.setColor(R.color.colorPrimary);
        dataSet.setValueTextSize(11f);


        BarData barData = new BarData(dataSet);

        XAxis xAxis = chart.getXAxis();
        final HashMap<Integer, String> numMap = new HashMap<>();
        numMap.put(0, "now");
        numMap.put(1, "15 min");
        numMap.put(2, "30 min");
        numMap.put(3, "45 min");


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
        chart.setData(barData);
        chart.setBackgroundColor(Color.parseColor("#8ABFC2"));

        xAxis.setCenterAxisLabels(false);
        xAxis.setDrawGridLines(false);

        xAxis.setGranularity(1);

        chart.setFitBars(true);
        chart.setBorderWidth(3.0f);
        chart.animateXY(1000, 1000);
        Description description = new Description();
        description.setText("Magnetfield");
        description.setTextSize(22);
        description.setTextColor(Color.WHITE);
        description.setPosition(400,100);
        chart.setDescription(description);
        chart.invalidate(); // refresh
        return mView;
    }

}
