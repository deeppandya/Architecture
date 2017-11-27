package com.example.deepp.architecture.networkcalls;

import com.example.deepp.architecture.model.UnsplashPhoto;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by deepp on 2017-11-27.
 */

public interface UnsplashPhotoService {

    @GET("photos?")
    Observable<List<UnsplashPhoto>> getUnsplashPhotos(@Query("client_id") String clientId, @Query("page") String page, @Query("per_page") String perPage, @Query("order_by") String orderBy);
}
