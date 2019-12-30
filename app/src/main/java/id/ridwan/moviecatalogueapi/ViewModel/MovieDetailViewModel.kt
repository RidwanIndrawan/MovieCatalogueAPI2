package id.ridwan.moviecatalogueapi.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.moviecatalogueapi.API.Config
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataDetailMovie
import retrofit2.Call
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {

    private var dataDetailMovie = MutableLiveData<DataDetailMovie>()

    fun setMovie(id:Int?,languageCode:String){
        Config().instance().getMovieDetail(id,BuildConfig.API_KEY,languageCode)
            .enqueue(object :retrofit2.Callback<DataDetailMovie>{
                override fun onFailure(call: Call<DataDetailMovie>, t: Throwable) {
                    Log.d("Failed", t.message)
                    dataDetailMovie.postValue(null)
                }

                override fun onResponse(
                    call: Call<DataDetailMovie>,
                    response: Response<DataDetailMovie>
                ) {
                   val detailMovie = DataDetailMovie(
                       response.body()?.overview,
                       response.body()?.runtime,
                       response.body()?.status,
                       response.body()?.backdrop
                   )
                    dataDetailMovie.postValue(detailMovie)
                }

            })
    }

    fun getDetailMovie(): MutableLiveData<DataDetailMovie>?{
        return dataDetailMovie
    }
}