package com.emon.retrofit_mvvm_livedatademo.repository;

import com.emon.retrofit_mvvm_livedatademo.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String BaseUrl = "https://jsonplaceholder.typicode.com/";
    @GET("posts")
    Call<List<Comment>> getPost();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getData(@Path("id") int postId);
}

