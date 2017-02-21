package fr.amrane.amranetest.intro.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import butterknife.ButterKnife;
import fr.amrane.amranetest.Activity.LoginActivity;
import fr.amrane.amranetest.R;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class SplashActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);
        ButterKnife.bind(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToTheNextScreen();
            }
        }, 3000);
    }

    private void navigateToTheNextScreen(){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
