package com.developeralamin.mvvmartic.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.developeralamin.mvvmartic.databinding.ActivityMainBinding;
import com.developeralamin.mvvmartic.service.model.Result;
import com.developeralamin.mvvmartic.view.adapter.TopMovieApater;
import com.developeralamin.mvvmartic.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MovieViewModel movieViewModel;

    private TopMovieApater apater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.recyclerView.setLayoutManager(layoutManager);


        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                apater = new TopMovieApater(MainActivity.this, results);
                binding.recyclerView.setAdapter(apater);

            }
        });
    }
}