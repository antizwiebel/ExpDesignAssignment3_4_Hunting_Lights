package expd.gjovik.ntnu.no.hunting_lights.magnetfield;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import expd.gjovik.ntnu.no.hunting_lights.R;
import expd.gjovik.ntnu.no.hunting_lights.TabViewPagerAdapter;
import expd.gjovik.ntnu.no.hunting_lights.lightpollution.LightPollutionFragmentMap;
import expd.gjovik.ntnu.no.hunting_lights.lightpollution.LightPollutionFragmentStatistics;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MagnetFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagnetFieldFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager firstViewPager;
    private View mView;

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
        mView = inflater.inflate(R.layout.fragment_magnet_field, container, false);
        firstViewPager = (ViewPager) mView.findViewById(R.id.viewpager_content);

        tabLayout = (TabLayout) mView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(firstViewPager);

        setupViewPager(firstViewPager);
        return mView;
    }

    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MagnetFieldFragmentMap(), "Map");
        adapter.addFragment(new MagnetFieldFragmentStatistics(), "Statistics");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
