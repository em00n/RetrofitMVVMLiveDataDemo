package com.emon.retrofit_mvvm_livedatademo.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.emon.retrofit_mvvm_livedatademo.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {

    private static ProjectRepository projectRepository;
    private ApiService apiService;

    public ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized ProjectRepository getInstance() {
        if (projectRepository == null) {
            projectRepository = new ProjectRepository();

        }
        return projectRepository;
    }


    public LiveData<List<Comment>> getData(int postId) {
        final MutableLiveData<List<Comment>> data = new MutableLiveData<>();
        apiService.getData(postId).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
