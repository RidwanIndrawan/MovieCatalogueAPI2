package id.ridwan.moviecatalogueapi.DataMaster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataMaster (
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("poster_path")
    var poster: String? = null,
    @SerializedName("original_title")
    var title: String? = null,
    @SerializedName("release_date")
    var date: String? = null,
    @SerializedName("status")
    var status: String? = null
):Parcelable