package com.example.android.examenadolfo.data.repository




import com.example.android.examenadolfo.data.network.HandleServiceError
import com.example.android.examenadolfo.data.network.ServiceApi
import com.example.android.examenadolfo.data.network.model.response.ListHeroesResponse
import com.example.android.examenadolfo.domain.data.HeroesRepository
import com.example.android.examenadolfo.utils.CONSTANTES.API_KEY
import com.example.android.examenadolfo.utils.CONSTANTES.API_KEY_PRIVATE
import com.example.android.examenadolfo.utils.md5
import com.example.android.examenadolfo.utils.treking.DateUtils
import io.reactivex.Single

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitHeroesRepository
@Inject constructor(
    private val userApi: ServiceApi
) : HandleServiceError(), HeroesRepository {



    override fun getListTvs( offset:String): Single<ListHeroesResponse> {
        var ts:String  = DateUtils.simpleDate()
        return userApi.listTvs(API_KEY,"10",offset,
            md5( ts+API_KEY_PRIVATE+ API_KEY),ts ).map { serviceResponse ->
            handleResponse(serviceResponse)
            val response = serviceResponse.body()
            return@map response
        }
    }







}