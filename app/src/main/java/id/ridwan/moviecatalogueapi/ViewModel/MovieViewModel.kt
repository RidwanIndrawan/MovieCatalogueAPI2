package id.ridwan.moviecatalogueapi.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.moviecatalogueapi.API.Config
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.Data
import id.ridwan.moviecatalogueapi.DataMaster.DataMaster
import retrofit2.Call
import retrofit2.Response


class MovieViewModel : ViewModel() {

    private val movies = MutableLiveData<ArrayList<DataMaster>>()

    fun setMovie(languageCode : String, page : Int){
        Config().instance().getMovies(
            BuildConfig.API_KEY, languageCode, page
        ).enqueue(object : retrofit2.Callback<Data>{
            override fun onFailure(call : Call<Data>, m : Throwable){
                Log.d("Failed",m.message)
                movies.postValue(null)
            }
            override fun onResponse(call : Call<Data>, response: Response<Data>){
                val listMovies = response.body()?.dataList
                movies.postValue(listMovies)
            }
        })
    }

    fun getMovies():LiveData<ArrayList<DataMaster>>{
        return movies
    }

    fun getMovieList() : ArrayList<DataMaster>?{
        return movies.value
    }
}