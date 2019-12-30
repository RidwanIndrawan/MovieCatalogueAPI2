package id.ridwan.moviecatalogueapi.DataMaster

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class DataDetailMovie(
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("runtime")
    var runtime: Int?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("backdrop_path")
    var backdrop: String?
) : Parcelable