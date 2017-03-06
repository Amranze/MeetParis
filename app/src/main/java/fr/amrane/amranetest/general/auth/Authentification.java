package fr.amrane.amranetest.general.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aaitzeouay on 22/02/2017.
 */

public class Authentification {
    public static final Authentification INSTANCE = new Authentification();

    private static final String PREFS_NAME = "MeetInParisSharedPreferences";
    private static final String PREF_USERNAME = "mail";
    private static final String PREF_PASSWORD = "password";

    public boolean getSharedPreferences(Context context){
        SharedPreferences pref = context.getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String username = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);
        Log.d("getSharedPreferences", username + " : "+password);
        return (username != null || password != null );
            /*return true;
        return false;*/
    }
    public void setSharedPreferences(String username, String password, Context context){
        context.getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME, username)
                .putString(PREF_PASSWORD, password)
                .apply();
    }
}
