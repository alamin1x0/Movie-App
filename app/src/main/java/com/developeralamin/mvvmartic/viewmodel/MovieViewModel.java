package com.developeralamin.mvvmartic.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.developeralamin.mvvmartic.service.model.Result;
import com.developeralamin.mvvmartic.service.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {


    private MovieRepository mRepo;


    public MovieViewModel(@NonNull Application application) {
        super(application);

        mRepo = MovieRepository.getInstance(application);


    }

    public LiveData<List<Result>> getTopRatedMovieList() {

        return mRepo.getTopRatedMovieList();

    }
}
