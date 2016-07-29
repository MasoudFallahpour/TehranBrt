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

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * This class does some initializations on app start.
 *
 * @author Masood Fallahpoor
 */
@ReportsCrashes(
        formUri = "https://mfxpert.cloudant.com/acra-tehranbrt/_design/acra-storage/_update/report",
        reportType = HttpSender.Type.JSON,
        httpMethod = HttpSender.Method.POST,
        formUriBasicAuthLogin = "sonedgedgeligreyeacionno",
        formUriBasicAuthPassword = "f94e6411e5b1b1afa909e3bc69c6c9f23e00815b",
        customReportContent = {
                ReportField.REPORT_ID, ReportField.APP_VERSION_CODE,
                ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION,
                ReportField.BUILD, ReportField.STACK_TRACE
        },
        mode = ReportingInteractionMode.DIALOG,
        resToastText = R.string.crash_toast_text,
        resDialogTitle = R.string.app_name,
        resDialogIcon = android.R.drawable.ic_dialog_info,
        resDialogText = R.string.crash_dialog_text,
        resDialogPositiveButtonText = R.string.crash_dialog_positive_button_text,
        resDialogNegativeButtonText = R.string.crash_dialog_negative_button_text)
public class TehranBrtApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {

        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/shabnam_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        ACRA.init(this);

    }

}
