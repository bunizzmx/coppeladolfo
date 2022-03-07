package com.example.android.examenadolfo.domain.data


import com.example.android.examenadolfo.data.network.model.response.ListHeroesResponse

import io.reactivex.Single


interface HeroesRepository {
    fun getListTvs(offset:String): Single<ListHeroesResponse>
}