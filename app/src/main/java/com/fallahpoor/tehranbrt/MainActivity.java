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
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.Window;

import com.akexorcist.localizationactivity.LocalizationActivity;

import de.cketti.library.changelog.ChangeLog;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * This Activity is the very first Activity that user sees when app is run.
 * It shows all the routes of Tehran's BRT buses as a list.
 *
 * @author Masood Fallahpoor
 */
// TODO: Provide a consistent icon for settings in navigation drawer
// TODO: Make the accent color of Support Preference and AlertDialogPro libraries consistent with the accent color of the whole app
public class MainActivity extends LocalizationActivity implements
        NavigationView.OnNavigationItemSelectedListener, RecyclerViewClickListener {

    public static final String ROUTE_NUMBER = "route_number";
    private DrawerLayout mDrawerLayout;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

        setDefaultLanguage(LocaleUtils.LANGUAGE_FA);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocaleUtils.setLocale(getLanguage());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        RoutesAdapter adapter = new RoutesAdapter(this, Route.getRoutes(this), this);

        RecyclerView routesRecyclerView = (RecyclerView) findViewById(R.id.routesRecyclerView);
        routesRecyclerView.setAdapter(adapter);
        routesRecyclerView.setLayoutManager(linearLayoutManager);

        setupWindowAnimation();

    } // end of method onCreate

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {
            case R.id.nav_settings:
                intent = new Intent(this, SettingsActivity.class);
                displayActivity(intent);
                break;
            case R.id.nav_latest_changes:
                displayChangeLogDialog();
                break;
            case R.id.nav_about:
                intent = new Intent(this, AboutActivity.class);
                displayActivity(intent);
                break;
            case R.id.nav_exit:
                finish();
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;

    } // end of method onNavigationItemSelected

    @Override
    public void recyclerViewListClicked(int position) {

        Intent intent = new Intent(MainActivity.this, StationsActivity.class);
        intent.putExtra(ROUTE_NUMBER, position + 1);

        displayActivity(intent);

    }

    private void setupWindowAnimation() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Transition explodeTransition = TransitionInflater.from(this).inflateTransition(
                    R.transition.explode);
            Window window = getWindow();

            window.setReenterTransition(explodeTransition);
            window.setExitTransition(explodeTransition);
            window.setAllowReturnTransitionOverlap(false);

        }

    }

    private void displayChangeLogDialog() {

        ChangeLog changeLog = new ChangeLog(this);

        if (getLanguage().equalsIgnoreCase(LocaleUtils.LANGUAGE_FA)) {
            changeLog.setDirection(ChangeLog.Direction.RTL);
        } else {
            changeLog.setDirection(ChangeLog.Direction.LTR);
        }

        changeLog.getFullLogDialog().show();

    }

    private void displayActivity(Intent intent) {

        ActivityOptionsCompat activityOptions = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
        }

    } // end of method displayActivity

} // end of class MainActivity
