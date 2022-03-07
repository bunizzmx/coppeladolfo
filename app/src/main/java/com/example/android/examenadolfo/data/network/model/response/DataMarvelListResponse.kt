package com.example.android.examenadolfo.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataMarvelListResponse(
    @Expose
    @SerializedName("offset")
    var page:Int,
    @Expose
    @SerializedName("limit")
    var limit:Int,
    @Expose
    @SerializedName("count")
    var count:Int,
    @Expose
    @SerializedName("total")
    var total:Int,
    @Expose
    @SerializedName("results")
    var results:ArrayList<Tv>
)