package com.github.anastasiazhukova.threading.executable;

import android.support.annotation.NonNull;

import com.github.anastasiazhukova.threading.IListener;
import com.github.anastasiazhukova.threading.IPublisher;

import java.util.concurrent.TimeUnit;

public class ThreadExample extends Executable {

    private static final String RESPONSE = "Returned from Thread";
    private static final int TIMEOUT = 6;

    public ThreadExample(@NonNull final IListener pListener, @NonNull final IPublisher pPublisher) {
        super(pListener, pPublisher);
    }

    @Override
    public void execute() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(TIMEOUT);
                } catch (final Exception pE) {
                    mPublisher.publishError(pE, mListener);
                }

                if (mPublisher != null) {
                    mPublisher.publishResult(RESPONSE, mListener);
                }
            }
        }).start();
    }
}
