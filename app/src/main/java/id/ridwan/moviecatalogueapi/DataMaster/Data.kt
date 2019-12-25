package id.ridwan.moviecatalogueapi.DataMaster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    @SerializedName("page")
    var page: Int?,
    @SerializedName("result")
    var dataList: ArrayList<DataMaster>?
) : Parcelable