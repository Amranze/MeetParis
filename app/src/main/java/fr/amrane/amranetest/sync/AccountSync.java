package fr.amrane.amranetest.sync;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.account.model.User;

/**
 * Created by aaitzeouay on 28/02/2017.
 */

public class AccountSync extends AsyncTask<String, Void, List<User>> {
    private final static String URL = "http://192.168.24.23:8080/MeetInParis/";
    private List<User> users;
    @Override
    protected List<User> doInBackground(String... params) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Log.d("params", params[0]);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            List<User> user= restTemplate.getForObject(URL+params[0], ArrayList.class);
            List<User> users = mapper.convertValue(user, new TypeReference<List<User>>() { });
            //Log.d("Users", users.get(0).toString());
            //List<Map<String, Object>> user= restTemplate.getForObject(URL+params[0], List.class);
            //Log.d("Users", ""+user.get(0).toString());
            return users;
        } catch (Exception e) {
            Log.e("AccountSync", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<User> accounts) {
        super.onPostExecute(accounts);
    }

    public List<User> getUsers(){
        return users;
    }
}
