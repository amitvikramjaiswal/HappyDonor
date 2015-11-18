package com.home.happydonor.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

/**
 * Created by ajaiswal on 9/3/2015.
 */
public class GPSEnableDisableReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LocationManager locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            // gps enabled
            Toast.makeText(context, "enabled", Toast.LENGTH_SHORT).show();
        } else {
            // gps disabled
            Toast.makeText(context, "disabled", Toast.LENGTH_SHORT).show();
        }
    }
}
