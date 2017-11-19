package com.github.anastasiazhukova.threading.executable;

import com.github.anastasiazhukova.threading.IListener;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class AsyncTaskExample implements IExecutable {

    private final MyAsyncTask mMyAsyncTask;

    public AsyncTaskExample(final IListener pListener) {
        mMyAsyncTask = new MyAsyncTask(pListener);
    }

    @Override
    public void execute() {
        mMyAsyncTask.execute();

    }

    public void executeOnExecutor(final Executor pExecutor) {
        mMyAsyncTask.executeOnExecutor(pExecutor);
    }

    private class MyAsyncTask extends android.os.AsyncTask<Void, Void, Object> {

        private static final String RESPONSE = "Returned from AsyncTask";
        private static final int TIMEOUT = 5;
        private final IListener mListener;

        MyAsyncTask(final IListener pListener) {
            mListener = pListener;
        }

        @Override
        protected Object doInBackground(final Void... params) {
            try {
                TimeUnit.SECONDS.sleep(TIMEOUT);
            } catch (final Exception pE) {
                return new Throwable(pE.getMessage());
            }
            return RESPONSE;
        }

        @Override
        protected void onPostExecute(final Object pO) {

            if (pO instanceof Throwable) {
                mListener.OnError((Throwable) pO);
            } else if (pO instanceof String) {
                mListener.onSuccess(pO.toString());
            } else {
                mListener.OnError(new Throwable("Wrong response format"));
            }

        }
    }

}

