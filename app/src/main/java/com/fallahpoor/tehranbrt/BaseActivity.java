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
 * This is the base class of all other Activities of this app.
 *
 * @author Masood Fallahpoor
 */
public class BaseActivity extends LocalizationActivity {

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

    protected void setupWindowAnimation() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition enterAnimation = TransitionInflater.from(this).inflateTransition(
                    R.transition.explode);
            getWindow().setEnterTransition(enterAnimation);
            getWindow().setAllowEnterTransitionOverlap(false);
        }

    }

} // end of class BaseActivity
