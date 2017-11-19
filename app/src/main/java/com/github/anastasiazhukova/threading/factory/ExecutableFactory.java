package com.github.anastasiazhukova.threading.factory;

import android.support.annotation.NonNull;

import com.github.anastasiazhukova.threading.IListener;
import com.github.anastasiazhukova.threading.executable.AsyncTaskExample;
import com.github.anastasiazhukova.threading.executable.ExecutorServiceExample;
import com.github.anastasiazhukova.threading.executable.IExecutable;
import com.github.anastasiazhukova.threading.executable.ThreadExample;
import com.github.anastasiazhukova.threading.IPublisher;

public class ExecutableFactory implements IExecutableFactory {

    @Override
    public AsyncTaskExample createAsyncTask(final IListener pListener) {
        return new AsyncTaskExample(pListener);
    }

    @Override
    public IExecutable createExecutableService(@NonNull final IListener pListener,
                                               @NonNull final IPublisher pPublisher) {
        return new ExecutorServiceExample(pListener, pPublisher);
    }

    @Override
    public IExecutable createThread(@NonNull final IListener pListener,
                                    @NonNull final IPublisher pPublisher) {
        return new ThreadExample(pListener, pPublisher);
    }
}
