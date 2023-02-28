package com.haznedar.newsapp.di

import com.haznedar.newsapp.BuildConfig
import com.haznedar.newsapp.data.remote.NewsAPI
import com.haznedar.newsapp.domain.repository.NewsRepository
import com.haznedar.newsapp.domain.repository.NewsRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRetrofitAPI(
        gsonConverterFactory: GsonConverterFactory
    ): NewsAPI {

        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build().create(NewsAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun injectRepo(api: NewsAPI) = NewsRepository(api) as NewsRepositoryInterface


}