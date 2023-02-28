package com.haznedar.newsapp.data.remote

import com.haznedar.newsapp.common.Constants.API_KEY
import com.haznedar.newsapp.data.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY,
    ): NewsModel



}