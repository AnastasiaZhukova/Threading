package com.github.anastasiazhukova.threading.executable;

import com.github.anastasiazhukova.threading.IListener;
import com.github.anastasiazhukova.threading.IPublisher;

abstract class Executable implements IExecutable {

    final IListener mListener;
    final IPublisher mPublisher;

    Executable(final IListener pListener, final IPublisher pPublisher) {
        mListener = pListener;
        mPublisher = pPublisher;
    }

    public abstract void execute();
}
