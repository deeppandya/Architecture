package com.example.deepp.architecture;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.deepp.architecture.viewmodel.UnsplashPhotosViewModel;

public class MainActivity extends AppCompatActivity {

    private UnsplashPhotosViewModel unsplashPhotosViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unsplashPhotosViewModel = ViewModelProviders.of(this).get(UnsplashPhotosViewModel.class);
        unsplashPhotosViewModel.getUser().observe(this, user -> {
            Log.e("Current Weather", user.get(0).getUser().getName());
            Log.e("Current Weather", user.get(1).getUser().getName());
            Log.e("Current Weather", user.get(2).getUser().getName());
            Log.e("Current Weather", user.get(3).getUser().getName());
        });
    }
}
