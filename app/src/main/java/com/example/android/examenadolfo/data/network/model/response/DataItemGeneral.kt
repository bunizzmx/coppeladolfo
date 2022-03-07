package com.example.android.examenadolfo.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataItemGeneral(
    @Expose
    @SerializedName("items")
    var items:ArrayList<ItemMarvel>,
    @Expose
    @SerializedName("returned")
    var returned:String,
    @Expose
    @SerializedName("collectionURI")
    var collectionURI:String,
    @Expose
    @SerializedName("available")
    var available:Int
)
