package fr.amrane.amranetest.Activity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
=======
import com.dd.processbutton.iml.ActionProcessButton;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rey.material.widget.CheckBox;
import com.rey.material.widget.ProgressView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

>>>>>>> feature/sprint/1/Fixing_Profile_Screen
import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.activity.HomeActivity;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.account.model.User;
import fr.amrane.amranetest.account.repository.AccountRepository;
import fr.amrane.amranetest.account.repository.AccountRepositoryImpl;
import fr.amrane.amranetest.general.auth.Authentification;
import fr.amrane.amranetest.sync.AccountSync;
import fr.amrane.amranetest.utils.ProgressGenerator;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static com.dd.processbutton.iml.ActionProcessButton.Mode.ENDLESS;

/**
 * Created by aaitzeouay on 12/12/2016.
 */

public class LoginActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener{
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Authentification authentification;

    @BindView(R.id.input_email)
    EditText _emailText;
<<<<<<< HEAD
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
=======
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    ActionProcessButton _loginButton;
>>>>>>> feature/sprint/1/Fixing_Profile_Screen
    @BindView(R.id.link_signup)
    TextView _signupLink;
    @BindView(R.id.login_progessview)
    ProgressView login_progessview;
    @BindView(R.id.chbox_remember_me)
    CheckBox chbox_remember_me;

    private Realm realm;
    private Account account;
    private AccountRepository accountRepository;
    private ProgressGenerator progressGenerator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }*/
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
<<<<<<< HEAD

=======
        setRealmConfiguration();
        setListeners();
        setupUI();
        accountRepository = new AccountRepositoryImpl();
        progressGenerator = new ProgressGenerator(this);
>>>>>>> feature/sprint/1/Fixing_Profile_Screen
        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                //Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(new Intent(getApplicationContext(), SignupActivity.class), REQUEST_SIGNUP);
            }
        });
    }

    private void setupUI() {
        _loginButton.setMode(ActionProcessButton.Mode.ENDLESS);
    }

    private void setListeners() {
        //final ProgressGenerator progressGenerator = new ProgressGenerator(this);
    }

    public void setRealmConfiguration(){
        /*RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("Account")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);*/
        realm = Realm.getDefaultInstance();

    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            _loginButton.setProgress(-1);
            onLoginFailed();
            return;
        }
        //progressGenerator.start(_loginButton);
        _loginButton.setProgress(1);
        _loginButton.setEnabled(false);

        /*final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme);
        //it was R.style.AppTheme_Dark_Dialog
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();*/

        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        login_progessview.setVisibility(View.VISIBLE);
                        // On complete call either onLoginSuccess or onLoginFailed
                        if(!checkUser(email, password)){
                            //_loginButton.setMode(ENDLESS);
                            //_loginButton.setMode(ENDLESS);
                            _loginButton.setProgress(-1);
                            onLoginFailed();
                            return;
                        }
                        if(chbox_remember_me.isChecked())
                            authentification.INSTANCE.setSharedPreferences(email, password, LoginActivity.this);
                        onLoginSuccess();
                        // onLoginFailed();
                        //progressDialog.dismiss();
                    }
                }, 3000);
    }

    private boolean checkUser(String mail, String password){
        //RealmResults<Account> accounts = realm.where(Account.class).equalTo("mail", mail).equalTo("password", password).findAll();
        //Log.d("accounts ", accounts.get(0).toString());
        /*RealmResults<Account> account =  realm.where(Account.class).contains("mail", mail).findAll();
        Log.d("Account ", account.get(0).toString());
        account =  realm.where(Account.class).equalTo("mail", mail).findAll();
        Log.d("Account equalTo ", account.get(0).toString());*/
        //return (accounts.size() != 0);

        //This for checking realm
        //return accountRepository.checkUser(mail, password);
        String URL = "findUser/"+mail+"/"+password;
        try {
            User user = new CheckAccount().execute(URL).get();
            if(user != null){
                Log.d("Users", user.toString());
                //accountRepository.addAccount();
                return true;
            }
        } catch (Exception e) {
            Log.d("Exception", e.getMessage());
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    @Override
    protected void onStart() {
        super.onStart();
        login_progessview.setVisibility(View.GONE);
    }

    @Override
    public void onComplete() {

    }

    class CheckAccount extends AsyncTask<String, Void, User> {
        private final static String URL = "http://192.168.24.23:8080/MeetInParis/Users/";

        @Override
        protected User doInBackground(String... params) {
            try {
                Log.d("params", params[0]);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                return restTemplate.getForObject(URL+params[0], User.class);
            } catch (Exception e) {
                Log.e("CheckAccount", e.getMessage(), e);
            }
            return null;
        }
    }
}
