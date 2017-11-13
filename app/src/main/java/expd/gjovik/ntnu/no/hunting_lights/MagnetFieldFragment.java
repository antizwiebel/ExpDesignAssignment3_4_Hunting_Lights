package expd.gjovik.ntnu.no.hunting_lights;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MagnetFieldFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagnetFieldFragment extends Fragment implements OnMapReadyCallback{

    private MapView mMap;
    private View mView;
    private GoogleMap mGoogleMap;
    private ImageView mImageVIew;

    //TODO: change coordinates
    private static final LatLng TROMSO = new LatLng(40.714086, -74.228697);

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
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_magnet_field, container, false);
        mImageVIew = (ImageView) mView.findViewById(R.id.imageOverlay);
        mImageVIew.setAlpha(0.5f);
        mMap = mView.findViewById(R.id.map);
        mImageVIew.bringToFront();

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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //set to tromso
        mGoogleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(TROMSO , 14.0f) );
    }
}
