package expd.gjovik.ntnu.no.hunting_lights.magnetfield;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import expd.gjovik.ntnu.no.hunting_lights.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MagnetFieldFragmentStatistics#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagnetFieldFragmentStatistics extends Fragment {


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
        return inflater.inflate(R.layout.fragment_magnet_field_fragment_statistics, container, false);
    }

}