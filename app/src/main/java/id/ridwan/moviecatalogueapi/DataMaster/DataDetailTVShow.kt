package id.ridwan.moviecatalogueapi.DataMaster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataDetailTVShow(
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("vote_average")
    var rating: Float?,
    @SerializedName("number_of_episodes")
    var episodes: String?,
    @SerializedName("number_of_seasons")
    var seasons: String?,
    @SerializedName("backdrop_path")
    var backdrop: String? = null
) : Parcelable