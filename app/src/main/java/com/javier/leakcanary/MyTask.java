package com.javier.leakcanary;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.squareup.haha.perflib.Main;

import java.lang.ref.WeakReference;

/**
 * Created by User on 2/2/2017.
 */

public class MyTask extends AsyncTask<Void, Void, Void>
{
    private static final String TAG = "MyTask_";
    private WeakReference <MainActivity> mainActivity;
    public MyTask(MainActivity mainActivity){
        this.mainActivity = new WeakReference<MainActivity>(mainActivity);
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < 50 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: "+ i + " "+mainActivity.get());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(mainActivity.get(), "MyTask finished", Toast.LENGTH_SHORT).show();
    }
}
