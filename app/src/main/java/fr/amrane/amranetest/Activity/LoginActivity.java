package fr.amrane.amranetest.Activity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
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

import com.rey.material.widget.ProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.activity.HomeActivity;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.general.auth.Authentification;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by aaitzeouay on 12/12/2016.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Authentification authentification;

    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;
    @BindView(R.id.login_progessview)
    ProgressView login_progessview;

    private Realm realm;
    private Account account;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }*/
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
        setRealmConfiguration();
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
            onLoginFailed();
            return;
        }

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
                            onLoginFailed();
                            return;
                        }
                        authentification.INSTANCE.setSharedPreferences(email, password, LoginActivity.this);
                        onLoginSuccess();
                        // onLoginFailed();
                        //progressDialog.dismiss();
                    }
                }, 3000);
    }

    private boolean checkUser(String mail, String password){
        RealmResults<Account> accounts = realm.where(Account.class).equalTo("mail", mail).equalTo("password", password).findAll();
        //Log.d("accounts ", accounts.get(0).toString());
        /*RealmResults<Account> account =  realm.where(Account.class).contains("mail", mail).findAll();
        Log.d("Account ", account.get(0).toString());
        account =  realm.where(Account.class).equalTo("mail", mail).findAll();
        Log.d("Account equalTo ", account.get(0).toString());*/
        return (accounts.size() != 0);
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
}
