package com.example.android.examenadolfo.data.network


import com.example.android.examenadolfo.data.network.model.response.ListHeroesResponse
import io.reactivex.Single
import retrofit2.Response

import retrofit2.http.*


interface ServiceApi {

    @GET("characters")
    fun listTvs(@Query("apikey") apiKey:String,@Query("limit") limit:String,@Query("offset") offset:String,
              @Query("hash") hash:String,  @Query("ts") ts:String): Single<Response<ListHeroesResponse>>


}
