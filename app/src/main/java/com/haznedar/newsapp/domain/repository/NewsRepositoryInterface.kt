package com.haznedar.newsapp.domain.repository

import com.haznedar.newsapp.data.model.NewsModel

interface NewsRepositoryInterface {

    suspend fun fetchNews(countryCode: String, pageNumber: Int): NewsModel



}