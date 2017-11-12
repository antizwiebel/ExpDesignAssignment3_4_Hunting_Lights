package expd.gjovik.ntnu.no.hunting_lights;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import java.nio.ByteBuffer;


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
    private static final LatLng NEWARK = new LatLng(40.714086, -74.228697);

    private static final LatLng NEAR_NEWARK =
            new LatLng(NEWARK.latitude - 0.001, NEWARK.longitude - 0.025);

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
        mView = inflater.inflate(R.layout.fragment_route, container, false);
        mImageVIew = mView.findViewById(R.id.imageOverlay);
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

        mGoogleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(69.653333, 18.958087) , 14.0f) );
        //mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NEWARK, 11));

        //BitmapDescriptor imageDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.newark_nj_1922);
        //mGoogleMap.addGroundOverlay(new GroundOverlayOptions()
        //        .image(imageDescriptor).position(new LatLng(69.653333, 18.958087), 4300f, 3025f)
        //        .transparency((float) 0.5));
    }
}
