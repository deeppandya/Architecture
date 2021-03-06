package com.example.deepp.architecture.datarepository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.deepp.architecture.BuildConfig;
import com.example.deepp.architecture.model.UnsplashPhoto;
import com.example.deepp.architecture.networkcalls.UnsplashPhotoService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by deepp on 2017-11-27.
 */

public class UnsplashPhotosRepository {

    private UnsplashPhotoService unsplashPhotoService;
    private static UnsplashPhotosRepository unsplashPhotosRepository;

    private UnsplashPhotosRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.UNSPLASH_END_POINT)
                .build();

        unsplashPhotoService = retrofit.create(UnsplashPhotoService.class);
    }

    public synchronized static UnsplashPhotosRepository getInstance() {
        if (unsplashPhotosRepository == null) {
            unsplashPhotosRepository = new UnsplashPhotosRepository();
        }
        return unsplashPhotosRepository;
    }

    public LiveData<List<UnsplashPhoto>> getUnsplashPhotos(String page,String perPage,String orderBy) {
        final MutableLiveData<List<UnsplashPhoto>> data = new MutableLiveData<>();
        unsplashPhotoService.getUnsplashPhotos(BuildConfig.UNSPLASH_CLIENT_ID, page, perPage, orderBy).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(unsplashPhotos -> {
                    Log.e("Current Weather", unsplashPhotos.get(0).getUser().getName());
                    data.setValue(unsplashPhotos);
                });
        return data;
    }
}

