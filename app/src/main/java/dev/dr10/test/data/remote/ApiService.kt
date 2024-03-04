package dev.dr10.test.data.remote

import dev.dr10.test.data.models.CategoryResponse
import dev.dr10.test.domain.utilities.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getCategories(): Response<CategoryResponse>
}