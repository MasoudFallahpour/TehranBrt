/*
    Copyright (C) 2016 Masood Fallahpoor

    This file is part of Tehran BRT.

    Tehran BRT is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Tehran BRT is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Tehran BRT. If not, see <http://www.gnu.org/licenses/>.
 */

package com.fallahpoor.tehranbrt;

import android.content.Context;
import android.content.res.Resources;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Station encapsulates the information associated with a station.
 */
public class Station {

    public final static int FEATURE_NONE = 0;
    public final static int FEATURE_ONE_WAY_DOWN = 1;
    public final static int FEATURE_ONE_WAY_UP = 2;
    public final static int FEATURE_METRO = 4;
    private String mStationName;
    private int mStationFeatures;
    private LatLng mStationPosition;

    public Station(String stationName, int stationFeatures, LatLng stationPosition) {

        mStationName = stationName;
        mStationFeatures = stationFeatures;
        mStationPosition = stationPosition;

    }

    public String getStationName() {
        return mStationName;
    }

    public int getStationFeatures() {
        return mStationFeatures;
    }

    public LatLng getStationPosition() {
        return mStationPosition;
    }

    public static List<Station> getStations(Context context, int routeNumber) {

        List<Station> stations = new ArrayList<>();
        int stationsNamesResId;
        int stationFeaturesResId;
        int stationsLatitudesResId = 0;
        int stationsLongitudesResId = 0;

        switch (routeNumber) {
            case 1:
                stationsNamesResId = R.array.route_1_stations;
                stationFeaturesResId = R.array.route_1_features;
                stationsLatitudesResId = R.array.route_1_latitudes;
                stationsLongitudesResId = R.array.route_1_longitudes;
                break;
            case 2:
                stationsNamesResId = R.array.route_2_stations;
                stationFeaturesResId = R.array.route_2_features;
                break;
            case 3:
                stationsNamesResId = R.array.route_3_stations;
                stationFeaturesResId = R.array.route_3_features;
                break;
            case 4:
                stationsNamesResId = R.array.route_4_stations;
                stationFeaturesResId = R.array.route_4_features;
                stationsLatitudesResId = R.array.route_4_latitudes;
                stationsLongitudesResId = R.array.route_4_longitudes;
                break;
            case 5:
                stationsNamesResId = R.array.route_5_stations;
                stationFeaturesResId = R.array.route_5_features;
                break;
            case 6:
                stationsNamesResId = R.array.route_6_stations;
                stationFeaturesResId = R.array.route_6_features;
                break;
            case 7:
                stationsNamesResId = R.array.route_7_stations;
                stationFeaturesResId = R.array.route_7_features;
                break;
            case 8:
                stationsNamesResId = R.array.route_8_stations;
                stationFeaturesResId = R.array.route_8_features;
                break;
            case 9:
                stationsNamesResId = R.array.route_9_stations;
                stationFeaturesResId = R.array.route_9_features;
                break;
            case 10:
                stationsNamesResId = R.array.route_10_stations;
                stationFeaturesResId = R.array.route_10_features;
                break;
            default:
                stationsNamesResId = R.array.route_1_stations;
                stationFeaturesResId = R.array.route_1_features;
        }

        Resources resources = context.getResources();

        String[] stationNames = resources.getStringArray(stationsNamesResId);
        int[] stationFeatures = resources.getIntArray(stationFeaturesResId);
        String[] stationsLatitudes = new String[0];
        String[] stationsLongitudes = new String[0];

        if (stationsLatitudesResId != 0) {
            stationsLatitudes = resources.getStringArray(stationsLatitudesResId);
            stationsLongitudes = resources.getStringArray(stationsLongitudesResId);
        }

        for (int i = 0; i < stationNames.length; i++) {

            String name = stationNames[i];
            int features = stationFeatures[i];

            double latitude = 0;
            double longitude = 0;

            if (stationsLatitudes.length != 0) {
                latitude = Double.valueOf(stationsLatitudes[i]);
                longitude = Double.valueOf(stationsLongitudes[i]);
            }

            stations.add(new Station(name, features, new LatLng(latitude, longitude)));

        }

        return stations;

    } // end of method getStations

} // end of class Station
