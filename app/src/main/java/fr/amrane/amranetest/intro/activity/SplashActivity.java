package fr.amrane.amranetest.intro.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.rey.material.widget.ProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.Activity.LoginActivity;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.activity.HomeActivity;
import fr.amrane.amranetest.application.App;
import fr.amrane.amranetest.general.auth.Authentification;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class SplashActivity extends Activity {
    private Authentification authentification;
    final private static String TAG = SplashActivity.class.getSimpleName();


    @BindView(R.id.tv_intro_splash)
    HTextView tv_intro_splash;
    @BindView(R.id.intro_progess_view)
    ProgressView intro_progess_view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);
        ButterKnife.bind(this);
        tv_intro_splash = (HTextView) findViewById(R.id.tv_intro_splash);
        tv_intro_splash.setAnimateType(HTextViewType.LINE);
        tv_intro_splash.animateText("Meet In Paris");

            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    navigateToTheNextScreen();
            }
        }, 3000);
    }

    private void navigateToTheNextScreen(){
        if(authentification.INSTANCE.getSharedPreferences(this))
            startActivity(new Intent(this, HomeActivity.class));
        else
            startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
