package com.emon.retrofit_mvvm_livedatademo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.emon.retrofit_mvvm_livedatademo.model.Comment;
import com.emon.retrofit_mvvm_livedatademo.repository.ProjectRepository;

import java.util.List;

public class ProjectDataViewModel extends AndroidViewModel {
    private final LiveData<List<Comment>> dataObsarvable;

    public ProjectDataViewModel(@NonNull Application application) {
        super(application);
        dataObsarvable = ProjectRepository.getInstance().getData(1);

    }

    public LiveData<List<Comment>> getDataObsarvable() {
        return dataObsarvable;
    }
}
