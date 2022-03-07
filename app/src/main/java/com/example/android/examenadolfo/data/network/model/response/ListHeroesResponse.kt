package com.example.android.examenadolfo.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListHeroesResponse(
    @Expose
    @SerializedName("code")
    var code:Int,
    @Expose
    @SerializedName("status")
    var status:String,
    @Expose
    @SerializedName("data")
    var data:DataMarvelListResponse
)
