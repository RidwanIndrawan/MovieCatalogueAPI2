package id.ridwan.moviecatalogueapi.DataMaster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataTVShows(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("poster_path")
    var poster: String? = null,
    @SerializedName("original_name")
    var title: String? = null,
    @SerializedName("first_air_date")
    var datefirst: String? = null,
    @SerializedName("vote_average")
    var vote:Float? = null
) : Parcelable