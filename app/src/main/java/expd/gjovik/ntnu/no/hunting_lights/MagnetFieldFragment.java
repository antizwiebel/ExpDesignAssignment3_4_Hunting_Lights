package expd.gjovik.ntnu.no.hunting_lights;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MagnetFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagnetFieldFragment extends Fragment {

    public MagnetFieldFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MagnetFieldFragment.
     */
    public static MagnetFieldFragment newInstance() {
        MagnetFieldFragment fragment = new MagnetFieldFragment();
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
        return inflater.inflate(R.layout.fragment_magnet_field, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
