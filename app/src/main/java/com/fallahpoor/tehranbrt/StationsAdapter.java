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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * This class is responsible for populating the RecyclerView of StationsActivity.
 */
public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<Station> mStationsList;
    private int mRouteColorResId;

    public StationsAdapter(Context context, List<Station> stations, int routeColorResId) {
        mStationsList = stations;
        mRouteColorResId = routeColorResId;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.station_list_item, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Station station = mStationsList.get(position);
        holder.setData(station);

    }

    @Override
    public int getItemCount() {
        return mStationsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mStationNameTextView;
        ImageView mStationBackgroundImageView;
        ImageView mStationDirectionImageView;
        ImageView mStationMetroImageView;

        MyViewHolder(View itemView) {

            super(itemView);

            mStationNameTextView = (TextView) itemView.findViewById(R.id.stationNameTextView);
            mStationBackgroundImageView = (ImageView) itemView.findViewById(
                    R.id.stationBackgroundImageView);
            mStationDirectionImageView = (ImageView) itemView.findViewById(
                    R.id.stationDirectionImageView);
            mStationMetroImageView = (ImageView) itemView.findViewById(R.id.stationMetroImageView);

        }


        public void setData(Station station) {

            mStationNameTextView.setText("");
            mStationBackgroundImageView.setBackgroundColor(0);
            mStationDirectionImageView.setImageResource(0);
            mStationMetroImageView.setImageResource(0);

            mStationNameTextView.setText(station.getStationName());
            mStationBackgroundImageView.setBackgroundColor(mRouteColorResId);

            switch (station.getStationFeatures()) {
                case Station.FEATURE_NONE:
                    break;
                case Station.FEATURE_ONE_WAY_DOWN:
                    mStationDirectionImageView.setImageResource(R.mipmap.ic_down_arrow);
                    break;
                case Station.FEATURE_ONE_WAY_UP:
                    mStationDirectionImageView.setImageResource(R.mipmap.ic_up_arrow);
                    break;
                case Station.FEATURE_METRO:
                    mStationMetroImageView.setImageResource(R.drawable.ic_metro_logo);
                    break;
                case (Station.FEATURE_ONE_WAY_DOWN + Station.FEATURE_METRO):
                    mStationDirectionImageView.setImageResource(R.mipmap.ic_down_arrow);
                    mStationMetroImageView.setImageResource(R.drawable.ic_metro_logo);
                    break;
                case (Station.FEATURE_ONE_WAY_UP + Station.FEATURE_METRO):
                    mStationDirectionImageView.setImageResource(R.mipmap.ic_up_arrow);
                    mStationMetroImageView.setImageResource(R.drawable.ic_metro_logo);
                    break;
            } // end of switch

        } // end of method setData

    } // end of inner class MyViewHolder

} // end of class StationsAdapter
