package com.home.happydonor.application;

import android.location.Location;
import android.support.multidex.MultiDexApplication;

import com.parse.Parse;

/**
 * Created by amitvikramjaiswal on 9/3/2015.
 */
public class HDApplication extends MultiDexApplication {

    private static Location location;

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location location) {
        HDApplication.location = location;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "84Mi8mSIu6XwmupaYsWJiRByFXUCSuGZ1f1HMGHt", "q70sa77vu75FrKBmoPQWD6MP4QXJXWoFFTkDxxdU");

    }
}
