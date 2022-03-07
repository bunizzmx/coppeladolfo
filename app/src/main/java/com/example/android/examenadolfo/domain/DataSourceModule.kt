package com.example.android.examenadolfo.domain

import com.example.android.examenadolfo.data.repository.RetrofitHeroesRepository
import com.example.android.examenadolfo.domain.data.HeroesRepository

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {


    @Singleton
    @Provides
    fun provideLoginRepository(repositoryRetrofit: RetrofitHeroesRepository): HeroesRepository {
        return repositoryRetrofit
    }


}