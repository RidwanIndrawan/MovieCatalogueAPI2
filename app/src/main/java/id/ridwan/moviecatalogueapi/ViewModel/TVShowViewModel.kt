package id.ridwan.moviecatalogueapi.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.moviecatalogueapi.API.Config
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataTVShows
import id.ridwan.moviecatalogueapi.DataMaster.ResponseTVShow
import retrofit2.Call
import retrofit2.Response

class TVShowViewModel : ViewModel() {
    private val tvshows = MutableLiveData<ArrayList<DataTVShows>>()

    fun setTVShow(languageCode : String, page : Int){
        Config().instance().getTVShows(
            BuildConfig.API_KEY, languageCode, page
        ).enqueue(object : retrofit2.Callback<ResponseTVShow>{
            override fun onFailure(call : Call<ResponseTVShow>, t : Throwable){
                Log.d("Failed",t.message)
                tvshows.postValue(null)
            }
            override fun onResponse(call : Call<ResponseTVShow>, response: Response<ResponseTVShow>){
                val listMovies = response.body()?.dataTVShows
                tvshows.postValue(listMovies)
            }
        })
    }
    fun getTVShows(): LiveData<ArrayList<DataTVShows>> {
        return tvshows
    }

    fun tvshowSize():Int?{
        return this.tvshows.value?.size
    }
}