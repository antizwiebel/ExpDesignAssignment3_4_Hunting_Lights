package expd.gjovik.ntnu.no.hunting_lights;


import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class WeatherFragment extends Fragment {


    View mView;

    public WeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WeatherFragment.
     */
    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
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
        mView= inflater.inflate(R.layout.fragment_weather, container, false);
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        populateChart();
    }


    //populate Chart
    void populateChart(){

        LineChart weatherChart = mView.findViewById(R.id.linechart1);


        List<Entry> lineList = new ArrayList<Entry>();
        lineList.add(new Entry(1f, 0f));
        lineList.add(new Entry(2f, 1f));
        lineList.add(new Entry(3f, 2f));
        lineList.add(new Entry(4f, 3f));
        lineList.add(new Entry(5f, 4f));

        LineDataSet learnDataSet = new LineDataSet(lineList, "Line");
        LineData lineData = new LineData(learnDataSet);
        weatherChart.setData(lineData);
        weatherChart.invalidate(); // refresh
        

    }

}
