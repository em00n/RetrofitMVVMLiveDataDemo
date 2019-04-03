package com.emon.retrofit_mvvm_livedatademo.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.emon.retrofit_mvvm_livedatademo.R;
import com.emon.retrofit_mvvm_livedatademo.view.adapter.MyAdapter;
import com.emon.retrofit_mvvm_livedatademo.model.Comment;
import com.emon.retrofit_mvvm_livedatademo.viewmodel.ProjectDataViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProjectDataViewModel projectDataViewModel;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBarID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        projectDataViewModel = ViewModelProviders.of(this).get(ProjectDataViewModel.class);
        projectDataViewModel.getDataObsarvable().observe(this, new Observer<List<Comment>>() {
            @Override
            public void onChanged(@Nullable List<Comment> comments) {
                recyclerView.setAdapter(new MyAdapter(MainActivity.this, comments));
                if (comments == null) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }


}
