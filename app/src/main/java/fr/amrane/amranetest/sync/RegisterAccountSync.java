package fr.amrane.amranetest.sync;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.amrane.amranetest.account.model.User;

/**
 * Created by Amrane Ait Zeouay on 06-Mar-17.
 */

public class RegisterAccountSync extends AsyncTask<User, Void, Boolean> {
    //private final static String URL = "http://192.168.218.1:8080/MeetInParis/Users/addUser";
    private final static String URL = "http://192.168.218.1:8080/MeetInParis/Users/addUserAndroid";

    @Override
    protected Boolean doInBackground(User... users) {
        //try {
            //Log.d("Sending User", ((User)users[0]).toString());
            Log.d("Sending User", users[0].getMail());
            User mUser = new User("Test", "Fuck", "Fuck@this.shit", "123145");
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            try {
                // Make the network request
                //ResponseEntity<User> response = restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<Object>(requestHeaders), User.class);
                ResponseEntity<User> response = restTemplate.postForEntity(URL, mUser, User.class);
                //Log.d("Response", response.getBody()+"");
                return true;
            } catch (HttpClientErrorException e) {
                Log.e("Sending", e.getLocalizedMessage(), e);
                return false;
            } catch (ResourceAccessException e) {
                Log.e("Sending", e.getLocalizedMessage(), e);
                return false;
            }
            /*HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Accept-Charset", "UTF-8");

            HttpEntity<User> request = new HttpEntity<User>(users[0], headers);
            RestTemplate rest = new RestTemplate();
            ResponseEntity<User> response = rest.postForEntity(URL, request, User.class);*/

            /*RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            restTemplate.postForEntity(URL, users[0], User.class);

            Log.d("User Sent", "Ok");
            return true;
        } catch (Exception e) {
            Log.e("AccountSync", e.getMessage(), e);
        }*/
        //return null;
    }
}
