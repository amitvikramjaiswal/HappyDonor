package com.home.happydonor.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.home.happydonor.R;
import com.home.happydonor.application.HDApplication;

import java.util.List;

/**
 * Created by amitvikramjaiswal on 20/08/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Context context;
    private AlertDialog.Builder alertDialogBuilder;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContext(this);
        if (!isInternetEnabled()) {
            Toast.makeText(context, getString(R.string.internet_unavailable), Toast.LENGTH_LONG).show();
            finish();
        }
        if (!isGPSEnabled()) {
            showAlertDialog(context, getString(R.string.enable_gps_title), String.format(getString(R.string.location_services_required), getString(R.string.app_name)), getString(R.string.yes), getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    enableGPS();
                }
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
        }
    }

    public void showAlertDialog(Context pContext, String pTitle, String pMessage, String pPositiveButtonText, String pNegetiveButtonText, DialogInterface.OnClickListener pOnPositiveClickListener, DialogInterface.OnClickListener pOnNegetiveClickListener) {
        alertDialogBuilder = new AlertDialog.Builder(pContext);
        alertDialogBuilder.setTitle(pTitle);
        alertDialogBuilder.setMessage(pMessage);
        alertDialogBuilder.setPositiveButton(pPositiveButtonText, pOnPositiveClickListener);
        alertDialogBuilder.setNegativeButton(pNegetiveButtonText, pOnNegetiveClickListener);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        if (!((Activity) context).isFinishing()) {
            alertDialog.show();
        }
    }

    public boolean isInternetEnabled() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        return false;
    }

    public boolean isGPSEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }

        if (bestLocation != null) {
            HDApplication.setLocation(bestLocation);
            return true;
        }
        return false;
    }

    public void enableGPS() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }

}
