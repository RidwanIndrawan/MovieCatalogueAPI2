package id.ridwan.moviecatalogueapi.API

import id.ridwan.moviecatalogueapi.BuildConfig
import id.ridwan.moviecatalogueapi.DataMaster.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Config {

    private fun doRequest() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun instance(): DataApi {
        return doRequest().create(DataApi::class.java)
    }

}