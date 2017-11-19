package com.github.anastasiazhukova.threading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


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
            public void onClick(View v) {
                handleAsyncTaskEvent();
            }
        });

        mExecutorServiceProgressView = findViewById(R.id.progressBar_executorservice);
        mExecutorServiceButton = findViewById(R.id.button_executorservice);
        mExecutorServiceButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
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

    private void handleAsyncTaskEvent() {}

    private void handleExecutorServiceEvent() {}

    private void handleThreadEvent() {}

}
