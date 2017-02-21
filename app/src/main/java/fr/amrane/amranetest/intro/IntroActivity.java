package fr.amrane.amranetest.intro;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.RetryConstraint;
import com.birbit.android.jobqueue.config.Configuration;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.rey.material.widget.ProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.amrane.amranetest.R;
import fr.amrane.amranetest.common.events.BusSingeton;
import fr.amrane.amranetest.database.RealmHandler;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class IntroActivity extends AppCompatActivity {
    private static final String TAG_DB_CONF_JOB = "db_conf_job";
    final private static String TAG = IntroActivity.class.getSimpleName();
    private Realm realm = Realm.getDefaultInstance();

    private JobManager setupJobManager;

    @BindView(R.id.tv_intro_splash)
    HTextView tv_intro_splash;
    @BindView(R.id.intro_progess_view)
    ProgressView intro_progess_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        setupJobManager = new JobManager(new Configuration.Builder(this).build());

        AsyncTaskCompat.executeParallel(new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                startDbConfigurationJob();
                return null;
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                intro_progess_view.setVisibility(View.GONE);
            }
        });
        //hTextView.setTypeface(FontManager.getInstance(getAssets()).getFont("fonts/font-name.ttf"));
        // be sure to set custom typeface before setting the animate type, otherwise the font may not be updated.
        tv_intro_splash = (HTextView) findViewById(R.id.tv_intro_splash);
        tv_intro_splash.setAnimateType(HTextViewType.LINE);
        tv_intro_splash.animateText("new simple string"); // animate

    }

    private void startDbConfigurationJob() {
        //setupJobManager.addJobInBackground();
        RealmHandler.INSTANCE.configureRealmDataBase();
    }

    private void navigateToTheNextScreenIn(){
        //startActivity(StartInspection.class);
        finish();
        /*new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        BusSingeton.INSTANCE.getBus().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusSingeton.INSTANCE.getBus().unregister(this);
    }
}
