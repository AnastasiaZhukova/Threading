package com.github.anastasiazhukova.threading;

public interface IListener {

    void onSuccess(String pResult);

    void OnError(Throwable pThrowable);
}
