package fr.amrane.amranetest.common.configuration;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.squareup.otto.Bus;

/**
 * Created by aaitzeouay on 21/02/2017.
 */

public abstract class BaseJob extends Job {
    private static final int PRIORITY = 1;

    private final Handler uiHandler;
    private final Bus bus;

    public BaseJob(String tag,Bus bus){
        super(new Params(PRIORITY)
                .setPersistent(false)
                .setRequiresNetwork(false)
                .addTags(tag));
        uiHandler = new Handler(Looper.getMainLooper());
        this.bus = bus;
    }

    protected <T> void deliverResult(final T object){
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                bus.post(object);
            }
        });
    }

    @Override
    public void onAdded() {
        //no implementation
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {
        //no implementation
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount,
                                                     int maxRunCount) {
        return RetryConstraint.CANCEL;
    }
}

