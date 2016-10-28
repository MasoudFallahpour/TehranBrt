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

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.widget.TextView;

/**
 * This Activity displays some information about the app including
 * its version, description, developer etc.
 *
 * @author Masood Fallahpoor
 */
public class AboutActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

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

        MovementMethod movementMethod = LinkMovementMethod.getInstance();

        ((TextView) findViewById(R.id.library1)).setMovementMethod(movementMethod);
        ((TextView) findViewById(R.id.library2)).setMovementMethod(movementMethod);
        ((TextView) findViewById(R.id.library3)).setMovementMethod(movementMethod);
        ((TextView) findViewById(R.id.library4)).setMovementMethod(movementMethod);
        ((TextView) findViewById(R.id.fontNameTextView)).setMovementMethod(movementMethod);

        setupWindowAnimation();

    } // end of method onCreate

} // end of class AboutActivity
