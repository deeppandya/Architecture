package com.example.deepp.architecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.deepp.architecture.datarepository.UnsplashPhotosRepository;
import com.example.deepp.architecture.model.UnsplashPhoto;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by deepp on 2017-11-27.
 */

public class UnsplashPhotosViewModel extends ViewModel {


    private LiveData<List<UnsplashPhoto>> user;
    private UnsplashPhotosRepository userRepo;

    public UnsplashPhotosViewModel() {
        userRepo = UnsplashPhotosRepository.getInstance();
    }

    public LiveData<List<UnsplashPhoto>> getUser() {
        return userRepo.getUnsplashPhotos("1","10","latest");
    }
}
