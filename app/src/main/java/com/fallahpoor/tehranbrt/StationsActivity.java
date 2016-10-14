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
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.akexorcist.localizationactivity.LocalizationActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * This Activity displays all the stations of a specific route.
 */
public class StationsActivity extends LocalizationActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        int routeNumber = getIntent().getExtras().getInt(MainActivity.ROUTE_NUMBER);
        int[] routeColors = getResources().getIntArray(R.array.route_colors);
        int routeColorResId = routeColors[routeNumber - 1];

        setTitle(getResources().getStringArray(R.array.activity_titles)[routeNumber - 1]);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        StationsAdapter adapter = new StationsAdapter(this, Station.getStations(this, routeNumber),
                routeColorResId);

        RecyclerView stationsRecyclerView = (RecyclerView) findViewById(R.id.stationsRecyclerView);
        stationsRecyclerView.setAdapter(adapter);
        stationsRecyclerView.setLayoutManager(linearLayoutManager);

        setupWindowAnimation();

    } // end of method onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_stations, menu);
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

    @Override
    public void onBackPressed() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }

        super.onBackPressed();

    }

    @Override
    public boolean onSupportNavigateUp() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }

        return super.onSupportNavigateUp();

    }

    private void setupWindowAnimation() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition enterAnimation = TransitionInflater.from(this).inflateTransition(
                    R.transition.explode);
            getWindow().setEnterTransition(enterAnimation);
            getWindow().setAllowEnterTransitionOverlap(false);
        }

    }

    private void displayHelpDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(getResources().getString(R.string.help))
                .setMessage(R.string.help_text)
                .setCancelable(true)
                .setPositiveButton(R.string.ok, null)
                .show();

    }

} // end of class StationsActivity
