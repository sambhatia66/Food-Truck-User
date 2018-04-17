package com.fluper.foodtruckuser.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fluper.foodtruckuser.R;
import com.fluper.foodtruckuser.model.GPSTracker;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng originLatLng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);



            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);



    }



    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera



        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        GPSTracker gpsTracker = new GPSTracker(this);
        Log.d("TAG", ""+gpsTracker.getLatitude()+" "+gpsTracker.getLongitude());

        originLatLng = new LatLng(gpsTracker.getLatitude(), gpsTracker.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.addMarker(markerOptions.position(originLatLng).title("My current location"));
        CameraUpdate cameraUpdateCenter = CameraUpdateFactory.newLatLng(originLatLng);
        CameraUpdate cameraUpdateZoom = CameraUpdateFactory.zoomTo(18);
        mMap.moveCamera(cameraUpdateCenter);
        mMap.animateCamera(cameraUpdateZoom);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.setTrafficEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

}
