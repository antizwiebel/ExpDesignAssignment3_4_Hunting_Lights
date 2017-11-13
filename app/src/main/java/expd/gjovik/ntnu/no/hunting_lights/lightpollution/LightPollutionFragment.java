package expd.gjovik.ntnu.no.hunting_lights.lightpollution;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import expd.gjovik.ntnu.no.hunting_lights.R;
import expd.gjovik.ntnu.no.hunting_lights.TabViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LightPollutionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LightPollutionFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager firstViewPager;
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
        firstViewPager = (ViewPager) mView.findViewById(R.id.viewpager_content);

        tabLayout = (TabLayout) mView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(firstViewPager);

        setupViewPager(firstViewPager);
        return mView;
    }

    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new LightPollutionFragmentMap(), "Map");
        adapter.addFragment(new LightPollutionFragmentStatistics(), "Statistics");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
