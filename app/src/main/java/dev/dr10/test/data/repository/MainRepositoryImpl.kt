package dev.dr10.test.data.repository

import dev.dr10.test.data.remote.ApiService
import dev.dr10.test.domain.repository.MainRepository
import dev.dr10.test.domain.utilities.CallHandler
import dev.dr10.test.domain.utilities.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): MainRepository {
    override suspend fun getCategories(): Resource<List<String>> = CallHandler.callHandler {
        val categories = apiService.getCategories().body()?.toList()
        return@callHandler if(categories.isNullOrEmpty()) emptyList() else categories
    }

}