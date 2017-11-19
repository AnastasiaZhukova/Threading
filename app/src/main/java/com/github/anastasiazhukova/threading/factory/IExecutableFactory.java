package com.github.anastasiazhukova.threading.factory;

import com.github.anastasiazhukova.threading.IListener;
import com.github.anastasiazhukova.threading.executable.IExecutable;
import com.github.anastasiazhukova.threading.IPublisher;

public interface IExecutableFactory {

    IExecutable createAsyncTask(IListener pListener);

    IExecutable createExecutableService(IListener pListener, IPublisher pPublisher);

    IExecutable createThread(IListener pListener, IPublisher pPublisher);

}
