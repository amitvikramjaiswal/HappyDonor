package com.home.happydonor.application;

import android.location.Location;
import android.support.multidex.MultiDexApplication;

/**
 * Created by ajaiswal on 9/3/2015.
 */
public class HDApplication extends MultiDexApplication {

    private static Location location;

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location) {
        HDApplication.location = location;
    }
}
