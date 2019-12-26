package id.ridwan.moviecatalogueapi.DataMaster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMovie (
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var dataMovies: ArrayList<DataMovies>?
):Parcelable