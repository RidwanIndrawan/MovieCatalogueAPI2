package id.ridwan.moviecatalogueapi.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.moviecatalogueapi.API.Config
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataMovies
import id.ridwan.moviecatalogueapi.DataMaster.ResponseMovie
import retrofit2.Call
import retrofit2.Response


class MovieViewModel : ViewModel() {

    private val movies = MutableLiveData<ArrayList<DataMovies>>()

    fun setMovie(languageCode : String, page : Int){
        Config().instance().getMovies(
            BuildConfig.API_KEY, languageCode, page
        ).enqueue(object : retrofit2.Callback<ResponseMovie>{
            override fun onFailure(call : Call<ResponseMovie>, t : Throwable){
                Log.d("Failed",t.message)
                movies.postValue(null)
            }
            override fun onResponse(call : Call<ResponseMovie>, response: Response<ResponseMovie>){
                val listMovies = response.body()?.dataMovies
                movies.postValue(listMovies)
            }
        })
    }
    fun getMovies():LiveData<ArrayList<DataMovies>>{
        return movies
    }
}