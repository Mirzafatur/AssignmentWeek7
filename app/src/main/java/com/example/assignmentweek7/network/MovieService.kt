package com.example.assignmentweek7.network

import com.example.assignmentweek7.model.ResponseMovies
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("3/movie/popular")
    fun getMovies(@Query("api_key") apiKey : String,
                    @Query("language") language : String,
                    @Query("page") page : Long) : Flowable<ResponseMovies>

}