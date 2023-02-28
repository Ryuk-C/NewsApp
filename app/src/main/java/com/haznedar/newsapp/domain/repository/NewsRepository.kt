package com.haznedar.newsapp.domain.repository

import com.haznedar.newsapp.data.model.NewsModel
import com.haznedar.newsapp.data.remote.NewsAPI
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api : NewsAPI
) : NewsRepositoryInterface {

    override suspend fun fetchNews(
        countryCode: String,
        pageNumber: Int
    ): NewsModel {

        return api.getNews(country = countryCode, pageNumber = pageNumber)

    }


}