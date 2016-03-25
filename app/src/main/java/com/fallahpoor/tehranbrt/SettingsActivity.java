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
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.akexorcist.localizationactivity.LocalizationActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * This Activity hosts a Fragment containing the settings of the app.
 */
public class SettingsActivity extends LocalizationActivity {

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
        setContentView(R.layout.activity_settings);

        setupWindowAnimation();

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

} // end of class SettingsActivity
