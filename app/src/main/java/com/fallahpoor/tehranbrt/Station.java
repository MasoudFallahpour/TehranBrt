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

    public Station(String stationName, int stationFeatures) {

        mStationName = stationName;
        mStationFeatures = stationFeatures;

    }

    public String getStationName() {
        return mStationName;
    }

    public int getStationFeatures() {
        return mStationFeatures;
    }

    public static List<Station> getStations(Context context, int routeNumber) {

        List<Station> stations = new ArrayList<>();
        int stationsResId;
        int stationFeaturesResId;

        switch (routeNumber) {
            case 1:
                stationsResId = R.array.route_1_stations;
                stationFeaturesResId = R.array.route_1_features;
                break;
            case 2:
                stationsResId = R.array.route_2_stations;
                stationFeaturesResId = R.array.route_2_features;
                break;
            case 3:
                stationsResId = R.array.route_3_stations;
                stationFeaturesResId = R.array.route_3_features;
                break;
            case 4:
                stationsResId = R.array.route_4_stations;
                stationFeaturesResId = R.array.route_4_features;
                break;
            case 5:
                stationsResId = R.array.route_5_stations;
                stationFeaturesResId = R.array.route_5_features;
                break;
            case 6:
                stationsResId = R.array.route_6_stations;
                stationFeaturesResId = R.array.route_6_features;
                break;
            case 7:
                stationsResId = R.array.route_7_stations;
                stationFeaturesResId = R.array.route_7_features;
                break;
            case 8:
                stationsResId = R.array.route_8_stations;
                stationFeaturesResId = R.array.route_8_features;
                break;
            case 9:
                stationsResId = R.array.route_9_stations;
                stationFeaturesResId = R.array.route_9_features;
                break;
            case 10:
                stationsResId = R.array.route_10_stations;
                stationFeaturesResId = R.array.route_10_features;
                break;
            default:
                stationsResId = R.array.route_1_stations;
                stationFeaturesResId = R.array.route_1_features;
        }

        String[] stationNames = context.getResources().getStringArray(stationsResId);
        int[] stationFeatures = context.getResources().getIntArray(stationFeaturesResId);

        for (int i = 0; i < stationNames.length; i++) {
            stations.add(new Station(stationNames[i], stationFeatures[i]));
        }

        return stations;

    } // end of method getStations

} // end of class Station
