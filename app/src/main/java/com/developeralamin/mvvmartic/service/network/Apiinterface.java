package com.developeralamin.mvvmartic.service.network;

import com.developeralamin.mvvmartic.service.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiinterface {

    @GET("3/movie/top_rated?api_key=509b8fc9d3c23400ba4c34b4d78f3261")
    Call<MovieModel> getTopRateMovies();

}
