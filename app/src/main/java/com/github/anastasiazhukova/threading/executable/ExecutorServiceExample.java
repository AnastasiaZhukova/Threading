package com.github.anastasiazhukova.threading.executable;

import android.support.annotation.NonNull;

import com.github.anastasiazhukova.threading.IListener;
import com.github.anastasiazhukova.threading.IPublisher;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample extends Executable {

    private static final String RESPONSE = "Returned from ExecutorService";
    private static final int TIMEOUT = 7;

    private static final Executor DEFAULT_EXECUTOR = Executors.newSingleThreadExecutor();

    public ExecutorServiceExample(@NonNull final IListener pListener, @NonNull final IPublisher pPublisher) {
        super(pListener, pPublisher);
    }

    @Override
    public void execute() {
        executeOnExecutor(DEFAULT_EXECUTOR);
    }

    public void executeOnExecutor(final Executor pExecutor) {

        final ExecutorService executorService = (ExecutorService) pExecutor;

        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(TIMEOUT);
                } catch (final Exception pE) {
                    mPublisher.publishError(pE, mListener);
                }
                mPublisher.publishResult(RESPONSE, mListener);

            }
        };

        executorService.execute(runnable);

    }
}

