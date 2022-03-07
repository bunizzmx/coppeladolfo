package com.example.android.examenadolfo.data.network.model.response

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Url(
    @Expose
    @SerializedName("type")
    var type:String,
    @Expose
    @SerializedName("url")
    var url:String

    )
