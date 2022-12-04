package com.example.footballapp.di

import com.example.footballapp.data.remote.FootballApi
import com.example.footballapp.data.repository.RepositoryChampionshipFootballImpl
import com.example.footballapp.data.repository.RepositoryEuropeFootballImpl
import com.example.footballapp.domain.repository.RepositoryChampionshipFootball
import com.example.footballapp.domain.repository.RepositoryEuropeFootball
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFootballApi() : FootballApi {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client : OkHttpClient.Builder = OkHttpClient.Builder()
        client.addInterceptor(logger)

        return Retrofit.Builder()
            .baseUrl(FootballApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(FootballApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryChampionshipFootball(api: FootballApi) : RepositoryChampionshipFootball {
        return RepositoryChampionshipFootballImpl(api)
    }

    @Provides
    @Singleton
    fun provideRepositoryEuropeFootball(api: FootballApi) : RepositoryEuropeFootball {
        return RepositoryEuropeFootballImpl(api)
    }
}