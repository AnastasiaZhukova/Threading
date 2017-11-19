package com.github.anastasiazhukova.threading;

import android.os.Handler;
import android.os.Looper;

import com.github.anastasiazhukova.threading.executable.IExecutable;
import com.github.anastasiazhukova.threading.factory.ExecutableFactory;
import com.github.anastasiazhukova.threading.factory.IExecutableFactory;

public final class ThreadingManager {

    public static final String ASYNC_TASK = "AsyncTask";
    public static final String EXECUTOR_SERVICE = "Executor service";
    public static final String THREAD = "Thread";
    private static ThreadingManager sThreadingManagerInstance;
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    private final IPublisher mPublisher = new IPublisher() {

        @Override
        public void publishResult(final String pResult, final IListener pListener) {
            mUiHandler.post(new Runnable() {

                @Override
                public void run() {
                    pListener.onSuccess(pResult);
                }
            });
        }

        @Override
        public void publishError(final Throwable pThrowable, final IListener pListener) {

            mUiHandler.post(new Runnable() {

                @Override
                public void run() {
                    pListener.OnError(pThrowable);
                }
            });

        }
    };

    private final IExecutableFactory mExecutableFactory = new ExecutableFactory();

    private ThreadingManager() {

    }

    public static ThreadingManager getInstance() {
        if (sThreadingManagerInstance == null) {
            synchronized (ThreadingManager.class) {
                sThreadingManagerInstance = new ThreadingManager();
            }
        }
        return sThreadingManagerInstance;
    }

    void load(final String pThreadingType, final ThreadingListener pThreadingListener) {
        IExecutable executable = null;
        switch (pThreadingType) {
            case (ASYNC_TASK): {
                executable = mExecutableFactory.createAsyncTask(pThreadingListener);
                break;
            }
            case (EXECUTOR_SERVICE): {
                executable = mExecutableFactory.createExecutableService(pThreadingListener, mPublisher);
                break;
            }
            case (THREAD): {
                executable = mExecutableFactory.createThread(pThreadingListener, mPublisher);
                break;
            }
            default: {
                mPublisher.publishError(new Throwable("No such threading type"), pThreadingListener);
            }
        }
        if (executable != null) {
            executable.execute();
        }
    }

    public interface ThreadingListener extends IListener {

    }

}
