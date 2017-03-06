package fr.amrane.amranetest.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class App extends Application {
    private static App context;

    public void onCreate() {
        super.onCreate();
        context = this;
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("MeetInParisAccount")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        //Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
        Log.d("App", "Going from here");
        //App.context = getApplicationContext();
    }

    public static App getContext() {
        return context;
    }
}
