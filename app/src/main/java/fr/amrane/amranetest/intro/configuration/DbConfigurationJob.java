package fr.amrane.amranetest.intro.configuration;

import android.app.Activity;

import com.squareup.otto.Bus;

import fr.amrane.amranetest.common.configuration.BaseJob;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public class DbConfigurationJob extends BaseJob {
    private Activity activity;

    public DbConfigurationJob(String tag, Bus bus, Activity activity) {
        super(tag, bus);
        this.activity = activity;
    }

    @Override
    public void onRun() throws Throwable {

    }
}
