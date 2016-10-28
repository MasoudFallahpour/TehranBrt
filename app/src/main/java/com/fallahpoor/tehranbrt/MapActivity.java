package com.fallahpoor.tehranbrt;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MapActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        setupWindowAnimation();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_map_activity, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_help:
                displayHelpDialog();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng TehranLatLng = new LatLng(35.688263, 51.389204);

        PolylineOptions line1 =
                new PolylineOptions().add(
                        new LatLng(35.723573, 51.519510),
                        new LatLng(35.717299, 51.498898),
                        new LatLng(35.708970, 51.472219),
                        new LatLng(35.704737, 51.457692),
                        new LatLng(35.702199, 51.448907),
                        new LatLng(35.702002, 51.447298),
                        new LatLng(35.701687, 51.426714),
                        new LatLng(35.701248, 51.405170),
                        new LatLng(35.700955, 51.391673),
                        new LatLng(35.700676, 51.378032),
                        new LatLng(35.700251, 51.360196),
                        new LatLng(35.699804, 51.340880),
                        new LatLng(35.700093, 51.339641),
                        new LatLng(35.700315, 51.339513),
                        new LatLng(35.700559, 51.339175),
                        new LatLng(35.700694, 51.338756),
                        new LatLng(35.700746, 51.337077),
                        new LatLng(35.700629, 51.336224),
                        new LatLng(35.700402, 51.335645),
                        new LatLng(35.700058, 51.335291),
                        new LatLng(35.699701, 51.334636),
                        new LatLng(35.699679, 51.331895),
                        new LatLng(35.699932, 51.331444),
                        new LatLng(35.700657, 51.331433),
                        new LatLng(35.700958, 51.331621),
                        new LatLng(35.701567, 51.331653)
                ).width(15).color(ContextCompat.getColor(this, R.color.red));

        mMap.addPolyline(line1);

        PolylineOptions line4 =
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

        mMap.addPolyline(line4);

        int lines[] = new int[]{1, 4};
        int color[] = new int[]{R.mipmap.ic_map_marker_hollow_red,
                R.mipmap.ic_map_marker_hollow_light_blue};

        for (int i = 0; i < lines.length; i++) {

            List<Station> stations = Station.getStations(this, lines[i]);

            for (Station station : stations) {

                BitmapDescriptor bitmapDescriptor;

                if (station.getStationFeatures() == Station.FEATURE_ONE_WAY_DOWN ||
                        station.getStationFeatures() == Station.FEATURE_ONE_WAY_UP ||
                        station.getStationFeatures() - Station.FEATURE_METRO == Station.FEATURE_ONE_WAY_DOWN ||
                        station.getStationFeatures() - Station.FEATURE_METRO == Station.FEATURE_ONE_WAY_UP) {
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(
                            R.mipmap.ic_map_marker_filled);
                } else {
                    bitmapDescriptor = BitmapDescriptorFactory.fromResource(color[i]);
                }

                mMap.addMarker(new MarkerOptions()
                        .position(station.getStationPosition())
                        .title(station.getStationName())
                        .draggable(false).icon(bitmapDescriptor));
            }

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TehranLatLng, 9));

    }

    private void displayHelpDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(getResources().getString(R.string.help))
                .setMessage(R.string.dialog_message_maps_activity)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, null)
                .show();

    }

} // end of class MapActivity
