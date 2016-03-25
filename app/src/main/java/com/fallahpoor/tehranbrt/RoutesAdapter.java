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
 * This class is responsible for populating the RecyclerView of MainActivity.
 */
public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<Route> mRoutesList;
    private RecyclerViewClickListener mClickListener;

    public RoutesAdapter(Context context, List<Route> routes, RecyclerViewClickListener
            clickListener) {
        mRoutesList = routes;
        mClickListener = clickListener;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.route_list_item, parent, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Route route = mRoutesList.get(position);
        holder.setData(route);

    }

    @Override
    public int getItemCount() {
        return mRoutesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mRouteName;
        ImageView mRouteColor;

        public MyViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);

            mRouteName = (TextView) itemView.findViewById(R.id.routeNameTextView);
            mRouteColor = (ImageView) itemView.findViewById(R.id.routeColorImageView);

        }


        public void setData(Route route) {

            mRouteName.setText(route.getRouteName());
            mRouteColor.setBackgroundColor(route.getRouteColor());

        }

        @Override
        public void onClick(View view) {
            mClickListener.recyclerViewListClicked(getLayoutPosition());
        }

    } // end of inner class MyViewHolder

} // end of class RoutesAdapter
