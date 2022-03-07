package com.example.android.examenadolfo.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemMarvel(
    @Expose
    @SerializedName("resourceURI")
    var resourceURI:String,
    @Expose
    @SerializedName("name")
    var name:String
)
