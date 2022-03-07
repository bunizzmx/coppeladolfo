package com.example.android.examenadolfo.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class thumbnail(
    @Expose
    @SerializedName("path")
    var path:String,
    @Expose
    @SerializedName("extension")
    var extension:String
)
