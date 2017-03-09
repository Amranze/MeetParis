package fr.amrane.amranetest;

import android.os.AsyncTask;
import android.test.ActivityUnitTestCase;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import fr.amrane.amranetest.account.model.User;
import fr.amrane.amranetest.sync.RegisterAccountSync;

/**
 * Created by Amrane Ait Zeouay on 07-Mar-17.
 */

public class RegisterAccountSyncTest{

    @Test
    public void sendUser(){
        User user = new User("Test", "Android", "func@gmail.com", "123456");
        new RegisterAccountSync().execute(user);
    }
    class RegisterAccountSync extends AsyncTask<User, Void, Boolean> {
        private final static String URL = "http://192.168.24.200:8080/MeetInParis/Users/addUser";

        @Override
        protected Boolean doInBackground(User... users) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Log.d("Sending User", ((User)users[0]).toString());
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.postForEntity(URL, (User)users[0], User.class);
                Log.d("User Sent", "Ok");
                return true;
            } catch (Exception e) {
                Log.e("AccountSync", e.getMessage(), e);
            }
            return null;
        }
    }

}
