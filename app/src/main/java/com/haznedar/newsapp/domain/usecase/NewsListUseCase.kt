package com.haznedar.newsapp.domain.usecase

import com.haznedar.newsapp.common.Resource
import com.haznedar.newsapp.common.internetCheck
import com.haznedar.newsapp.data.model.NewsModel
import com.haznedar.newsapp.domain.repository.NewsRepositoryInterface
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

class NewsListUseCase @Inject constructor(

    private val repository: NewsRepositoryInterface

) {

    operator fun invoke(
        countryCode: String,
        pageNumber: Int
    ): Flow<Resource<NewsModel>> = flow {

        try {

            emit(Resource.Loading())

            val process = repository.fetchNews(
                countryCode = countryCode, pageNumber = pageNumber
            )

            coroutineScope {

                emit(Resource.Success(process))

            }

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))

        } catch (e: IOException) {

            if (!internetCheck()) {

                emit(Resource.Internet("Please, check your internet connection."))

            } else {

                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured!"))

            }
        }

    }.flowOn(Dispatchers.IO)

}