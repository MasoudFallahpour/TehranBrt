package com.fallahpoor.tehranbrt;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng TehranLatLng = new LatLng(35.688263, 51.389204);
        PolylineOptions line =
                new PolylineOptions().add(
                        new LatLng(35.651283, 51.419156),
                        new LatLng(35.650671, 51.421367),
                        new LatLng(35.647057, 51.421410),
                        new LatLng(35.649503, 51.399075),
                        new LatLng(35.650008, 51.397878),
                        new LatLng(35.659228, 51.391696),
                        new LatLng(35.662344, 51.387625),
                        new LatLng(35.663225, 51.384766),
                        new LatLng(35.664449, 51.383226),
                        new LatLng(35.664549, 51.382523),
                        new LatLng(35.665212, 51.382024),
                        new LatLng(35.681774, 51.380147),
                        new LatLng(35.694087, 51.378763),
                        new LatLng(35.705335, 51.377776),
                        new LatLng(35.718550, 51.378312),
                        new LatLng(35.722250, 51.379728),
                        new LatLng(35.727012, 51.382770),
                        new LatLng(35.728780, 51.383253),
                        new LatLng(35.741695, 51.383725),
                        new LatLng(35.746659, 51.385785),
                        new LatLng(35.754878, 51.386493),
                        new LatLng(35.760529, 51.388757),
                        new LatLng(35.769496, 51.387448),
                        new LatLng(35.771698, 51.387995),
                        new LatLng(35.779654, 51.392855),
                        new LatLng(35.781003, 51.393284),
                        new LatLng(35.788288, 51.391954),
                        new LatLng(35.789376, 51.392185),
                        new LatLng(35.790899, 51.393885),
                        new LatLng(35.793631, 51.401921),
                        new LatLng(35.793570, 51.403670),
                        new LatLng(35.791804, 51.407124),
                        new LatLng(35.791808, 51.411555),
                        new LatLng(35.790707, 51.417349)
                ).width(15).color(ContextCompat.getColor(this, R.color.light_blue));

        mMap.addPolyline(line);

        List<Station> stations = Station.getStations(this, 4);

        for(Station station : stations) {
            mMap.addMarker(new MarkerOptions()
                    .position(station.getStationPosition())
                    .title(station.getStationName())
                    .draggable(false));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TehranLatLng, 9));

    }

} // end of class MapActivity
