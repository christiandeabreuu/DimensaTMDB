package com.example.desafiodimensa.data.remote

import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.data.model.MovieResponse
import com.example.desafiodimensa.data.model.ReviewResponse
import com.example.desafiodimensa.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDbApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        //@Query("api_key") apiKey: String = Constants.API_KEY,
        // tirar o parametro do fragment por ser regra de negocio e trazer pra chamada
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/upcoming")
    suspend fun getComingSoonMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getMorePopularMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("movie/{movie_id}/reviews")
    suspend fun getReviews(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): ReviewResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY,
    ): DetailsMovie
}