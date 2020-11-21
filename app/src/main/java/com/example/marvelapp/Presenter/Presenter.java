package com.example.marvelapp.Presenter;

public interface Presenter {
    void onCreate();
    void onStart();
    void onRestart();
    void onPause();
    void onResume();
    void onStop();
    void onDestroy();
}
