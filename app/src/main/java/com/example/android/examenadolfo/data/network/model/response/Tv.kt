package com.example.android.examenadolfo.data.network.model.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tv(

    @Expose(serialize = false,deserialize = false)
    @SerializedName("id")
    var id:Int,

    @Expose
    @SerializedName("name")
    var name:String,

    @Expose
    @SerializedName("description")
    var description:String,

    @Expose
    @SerializedName("thumbnail")
    var thumbnail:thumbnail?,



    @Expose
    @SerializedName("urls")
    var urls:ArrayList<Url>,


    @Expose
    @SerializedName("comics")
    var comics:DataItemGeneral?,


    @Expose
    @SerializedName("series")
    var series:DataItemGeneral?,


    @Expose
    @SerializedName("stories")
    var stories:DataItemGeneral?,


    @Expose
    @SerializedName("events")
    var events:DataItemGeneral?

):Serializable {
    constructor() : this(0, "",
        "", null,arrayListOf<Url>(), null,
        null, null, null
    )
}
