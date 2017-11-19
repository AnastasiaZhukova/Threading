package com.github.anastasiazhukova.threading;

import com.github.anastasiazhukova.threading.IListener;

public interface IPublisher {

    void publishResult(final String pResult, final IListener pListener);

    void publishError(final Throwable pThrowable, final IListener pListener);

}
