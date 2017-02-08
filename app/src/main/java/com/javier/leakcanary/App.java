package com.javier.leakcanary;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by User on 2/2/2017.
 */
public class App extends Application {
    private static final String TAG = "AppTAG_" ;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code..
    }
}
