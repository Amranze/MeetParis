package fr.amrane.amranetest.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class App extends Application {
    private static final String TAG = "App";
    private ExecutorService threadPool;
    private static WeakReference<App> appContext;
    private WeakReference<Activity> topActivity = new WeakReference<>(null);
    private WeakReference<Snackbar> internetSnackbar = new WeakReference<>(null);

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //MultiDex.install(this);
    }

    public static Context getAppContext() {
        return appContext != null ? appContext.get() : null;
    }

    public static void setInternetSnackbar(Snackbar snackbar) {
        getApp().internetSnackbar = new WeakReference<>(snackbar);
    }

    public static App getApp() {
        return appContext != null ? appContext.get() : null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        appContext = new WeakReference<>(this);
        threadPool = Executors.newFixedThreadPool(4);
    }
}
