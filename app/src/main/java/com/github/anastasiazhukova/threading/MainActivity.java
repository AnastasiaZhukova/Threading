package com.github.anastasiazhukova.threading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ERROR = "Error";

    private View mAsyncTaskProgressView;
    private View mAsyncTaskButton;
    private View mExecutorServiceProgressView;
    private View mExecutorServiceButton;
    private View mThreadProgressView;
    private View mThreadButton;

    private TextView mTextView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {

        mTextView = findViewById(R.id.textView_main);

        mAsyncTaskProgressView = findViewById(R.id.progressBar_asynctask);
        mAsyncTaskButton = findViewById(R.id.button_asynctask);
        mAsyncTaskButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                handleAsyncTaskEvent();
            }
        });

        mExecutorServiceProgressView = findViewById(R.id.progressBar_executorservice);
        mExecutorServiceButton = findViewById(R.id.button_executorservice);
        mExecutorServiceButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                handleExecutorServiceEvent();
            }
        });

        mThreadProgressView = findViewById(R.id.progressBar_thread);
        mThreadButton = findViewById(R.id.button_thread);
        mThreadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                handleThreadEvent();
            }
        });

    }

    private void handleAsyncTaskEvent() {
        mAsyncTaskProgressView.setVisibility(View.VISIBLE);
        ThreadingManager.getInstance().load(ThreadingManager.ASYNC_TASK,
                new ThreadingManager.ThreadingListener() {

                    @Override
                    public void onSuccess(final String pResult) {
                        setResult(pResult);
                        mAsyncTaskProgressView.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void OnError(final Throwable pThrowable) {
                        setError(ERROR);
                        mAsyncTaskProgressView.setVisibility(View.INVISIBLE);

                    }
                });
    }

    private void handleExecutorServiceEvent() {
        mExecutorServiceProgressView.setVisibility(View.VISIBLE);
        ThreadingManager.getInstance().load(ThreadingManager.EXECUTOR_SERVICE,
                new ThreadingManager.ThreadingListener() {

                    @Override
                    public void onSuccess(final String pResult) {
                        setResult(pResult);
                        mExecutorServiceProgressView.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void OnError(final Throwable pThrowable) {
                        setError(ERROR);
                        mExecutorServiceProgressView.setVisibility(View.INVISIBLE);

                    }
                });
    }

    private void handleThreadEvent() {
        mThreadProgressView.setVisibility(View.VISIBLE);
        ThreadingManager.getInstance().load(ThreadingManager.THREAD,
                new ThreadingManager.ThreadingListener() {

                    @Override
                    public void onSuccess(final String pResult) {
                        setResult(pResult);
                        mThreadProgressView.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void OnError(final Throwable pThrowable) {
                        setError(ERROR);
                        mThreadProgressView.setVisibility(View.INVISIBLE);

                    }
                });

    }

    private void setResult(final String pResult) {
        mTextView.setText(pResult);

    }

    private void setError(final String pError) {
        mTextView.setText(pError);

    }

}
