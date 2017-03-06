package fr.amrane.amranetest.application;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import fr.amrane.amranetest.account.model.User;

/**
 * Created by Amrane Ait Zeouay on 28-Feb-17.
 */

public class AccountSync extends AsyncTask<String, Void, String> {
    private static final String URL = "http://192.168.43.47:8080/MeetInParis/Users/getAllUsers";
    private List<User> users;

    @Override
    protected String doInBackground(String... strings) {
        users = new ArrayList<User>();
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            users = (ArrayList<User>) restTemplate.getForObject(URL, ArrayList.class);
            //Log.d("Size ", ""+users.size());
            Log.d("Size ", users.toString());
            return null;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }
}
