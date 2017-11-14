package expd.gjovik.ntnu.no.hunting_lights.weather;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import expd.gjovik.ntnu.no.hunting_lights.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragmentMap extends Fragment implements OnMapReadyCallback {

    private MapView mMap;
    private View mView;
    private GoogleMap mGoogleMap;
    private ImageView mImageView;

    //TODO: change coordinates
    private static final LatLng TROMSO = new LatLng(69.649208, 18.955324);

    public WeatherFragmentMap() {
        // Required empty public constructor
    }

    public static WeatherFragmentMap newInstance() {
        WeatherFragmentMap fragment = new WeatherFragmentMap();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_weather_fragment_map, container, false);
        mImageView = mView.findViewById(R.id.imageOverlay);
        mImageView.setAlpha(0.3f);
        mMap = mView.findViewById(R.id.map);
        mImageView.bringToFront();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mMap != null) {
            mMap.onCreate(null);
            mMap.onResume();
            mMap.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //set to tromso
        mGoogleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(TROMSO , 10) );
    }
}
