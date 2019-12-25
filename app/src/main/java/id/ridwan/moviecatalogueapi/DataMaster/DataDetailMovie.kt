package id.ridwan.moviecatalogueapi.DataMaster

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class DataDetailMovie(
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("vote_average")
    var rating: Float?,
    @SerializedName("budget")
    var budget: String?,
    @SerializedName("revenue")
    var revenue: String?,
    @SerializedName("runtime")
    var runtime: Int?,
    @SerializedName("backdrop_path")
    var backdrop: String? = null
) : Parcelable