package com.developeralamin.mvvmartic.service.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.developeralamin.mvvmartic.service.model.MovieModel;
import com.developeralamin.mvvmartic.service.model.Result;
import com.developeralamin.mvvmartic.service.network.Apiinstance;
import com.developeralamin.mvvmartic.service.network.Apiinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository instance;
    private static Context mcontext;
    private MovieModel movieModel;
    private List<Result> mResults;
    private MutableLiveData mLiveData;

    public static MovieRepository getInstance(Context context) {

        if (instance == null) {
            mcontext = context;
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList() {


        if (mLiveData == null){
            mLiveData = new MutableLiveData();
        }

        Apiinterface apiinterface = Apiinstance.getApiInstance().create(Apiinterface.class);
        Call<MovieModel> call = apiinterface.getTopRateMovies();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                movieModel = response.body();
                mResults = movieModel.getResults();

                mLiveData.postValue(mResults);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mLiveData;

    }
}
