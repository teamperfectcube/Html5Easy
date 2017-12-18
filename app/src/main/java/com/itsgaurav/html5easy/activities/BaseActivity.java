/*
 * MIT License
 *
 * Copyright (c) 2017 Perfect Cube
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.itsgaurav.html5easy.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.itsgaurav.html5easy.R;

/**
 * All Appcompat Activities must extend this class.
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate this view
        getMenuInflater()
                .inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Navigate back to previous screen
                finish();
                return true;
            case R.id.action_rate_us:
                openRateUsScreen();
                return true;
            case R.id.action_other_app:
                openDeveloperPage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Method to redirect user to app listing page on google play store.
     */
    private void openRateUsScreen() {
        //To get the package name
        String appPackageName = getPackageName();
        try {
            //To redirect to google play store
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            //if play store is not installed
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    /**
     * Method to redirect user to developer page on google play store.
     */
    private void openDeveloperPage() {
        String developerID = "8667060650041201154";
        try {
            //To redirect to google play store
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://dev?id=" + developerID)));
        } catch (android.content.ActivityNotFoundException anfe) {
            //if play store is not installed
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/dev?id=" + developerID)));
        }
    }
}
