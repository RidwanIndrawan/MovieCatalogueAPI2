package id.ridwan.moviecatalogueapi.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ridwan.moviecatalogueapi.API.Config
import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.DataDetailTVShow
import retrofit2.Call
import retrofit2.Response

class TVShowDetailViewModel : ViewModel() {

    private var dataDetailTVShow = MutableLiveData<DataDetailTVShow>()

    fun setTVShow(id:Int?,languageCode:String){
        Config().instance().getTVShowsDetail(id,BuildConfig.API_KEY,languageCode)
            .enqueue(object : retrofit2.Callback<DataDetailTVShow>{
                override fun onFailure(call: Call<DataDetailTVShow>, t: Throwable) {
                  Log.d("Failed",t.message)
                    dataDetailTVShow.postValue(null)
                }

                override fun onResponse(
                    call: Call<DataDetailTVShow>,
                    response: Response<DataDetailTVShow>
                ) {
                  val detailTVShow = DataDetailTVShow(
                      response.body()?.overview,
                      response.body()?.episodes,
                      response.body()?.seasons,
                      response.body()?.backdrop,
                      response.body()?.status
                  )
                    dataDetailTVShow.postValue(detailTVShow)
                }

            })
    }

    fun getDetailTVShow():MutableLiveData<DataDetailTVShow>?{
        return dataDetailTVShow
    }

}