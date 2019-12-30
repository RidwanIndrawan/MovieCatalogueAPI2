package id.ridwan.moviecatalogueapi.API

import id.ridwan.moviecatalogueapi.DataMaster.DataDetailMovie
import id.ridwan.moviecatalogueapi.DataMaster.DataDetailTVShow
import id.ridwan.moviecatalogueapi.DataMaster.ResponseMovie
import id.ridwan.moviecatalogueapi.DataMaster.ResponseTVShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DataApi {

    @GET("3/discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<ResponseMovie>

    @GET("3/movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Int?,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DataDetailMovie>

    @GET("3/discover/tv")
    fun getTVShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<ResponseTVShow>

    @GET("3/tv/{id}")
    fun getTVShowsDetail(
        @Path("id") id: Int?,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<DataDetailTVShow>
}