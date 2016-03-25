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
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;
import android.widget.TextView;

import com.akexorcist.localizationactivity.LocalizationActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * This Activity displays some information about the app including
 * its version, description, developer etc.
 *
 * @author Masood Fallahpoor
 */
public class AboutActivity extends LocalizationActivity {

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
        setContentView(R.layout.activity_about);

        TextView appVersionTextView = (TextView) findViewById(R.id.appVersionTextView);

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);

            appVersionTextView.setText(getString(R.string.app_version_format,
                    packageInfo.versionName));

        } catch (NameNotFoundException e) {
            appVersionTextView.setText("1.0");
        }

        setupWindowAnimation();

    } // end of method onCreate

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

} // end of class AboutActivity
