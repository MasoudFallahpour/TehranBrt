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
 * Class Route encapsulates the information associated with a route.
 */
public class Route {

    private String mRouteName;
    private int mRouteColor;

    public Route(String routeName, int routeColor) {

        mRouteName = routeName;
        mRouteColor = routeColor;

    }

    public String getRouteName() {
        return mRouteName;
    }

    public int getRouteColor() {
        return mRouteColor;
    }

    public static List<Route> getRoutes(Context context) {

        List<Route> routes = new ArrayList<>();
        String[] routeNames = context.getResources().getStringArray(R.array.route_names);
        int[] routeColors = context.getResources().getIntArray(R.array.route_colors);

        for (int i = 0; i < routeNames.length; i++) {
            routes.add(new Route(routeNames[i], routeColors[i]));
        }

        return routes;

    }

} // end of class Route
