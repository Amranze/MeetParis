package fr.amrane.amranetest.Activity;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.widget.ProgressView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.activity.HomeActivity;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.common.utils.TimePickerFragment;
import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by aaitzeouay on 12/12/2016.
 */

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @BindView(R.id.input_firstname) EditText _firstNameText;
    @BindView(R.id.input_lastname) EditText _lastNameText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;
    @BindView(R.id.input_confirm_password) EditText _confirmPasswordText;
    @BindView(R.id.dialog_bt_date) EditText _dialog_bt_date;
    @BindView(R.id.signup_progessview) ProgressView signup_progessview;

    //private Fragment datePickerFragment;
    private Realm realm;
    private Account account;
    //private String firstName, lastName, email, password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRealmConfiguration();
        //realm = Realm.getDefaultInstance();
        setContentView(R.layout.signup_layout);
        ButterKnife.bind(this);
        setOnClickListener();
        //datePickerFragment = new TimePickerFragment();
    }

    public void setRealmConfiguration(){
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("Account")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);

    }
    private void setOnClickListener() {
        _dialog_bt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDatePickerDialog(true);
            }
        });

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        /*final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        //it was R.style.AppTheme_Dark_Dialog
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();*/
        final String firstName = _firstNameText.getText().toString();
        final String lastName = _lastNameText.getText().toString();
        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();
        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        signup_progessview.setVisibility(View.VISIBLE);
                        saveAccount(firstName, lastName, email, password);
                        onSignupSuccess();
                        // onSignupFailed();
                        //progressDialog.dismiss();
                    }
                }, 3000);
    }

    //String firstName, String lastName, String email, String password
    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        signup_progessview.setVisibility(View.GONE);
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
    }

    public void saveAccount(String firstName, String lastName, String email, String password){
        realm.beginTransaction();
        account = realm.createObject(Account.class);
        account.setFirstname(firstName);
        account.setLastname(lastName);
        account.setMail(email);
        account.setBirthdate(new Date());
        //TODO crypt the password
        account.setPassword(password);
        realm.commitTransaction();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String firstName = _firstNameText.getText().toString();
        String lastName = _lastNameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String confirmPassword = _confirmPasswordText.getText().toString();

        if(!password.equals(confirmPassword)){
            _confirmPasswordText.setError("Your password doesn't match");
            valid = false;
        } else {
            _confirmPasswordText.setError(null);
        }

        if (firstName.isEmpty() || firstName.length() < 3) {
            _firstNameText.setError("at least 3 characters");
            valid = false;
        } else {
            _firstNameText.setError(null);
        }

        if (lastName.isEmpty() || lastName.length() < 3) {
            _lastNameText.setError("at least 3 characters");
            valid = false;
        } else {
            _lastNameText.setError(null);
        }

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
        //signup_progessview.setVisibility(View.GONE);
    }

    private void showDatePickerDialog(boolean updateDate) {
        //datePickerFragment.getFragmentManager().beginTransaction().commit();
    }
}
