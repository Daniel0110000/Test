package dev.dr10.test.domain.repository

import dev.dr10.test.domain.utilities.Resource

interface MainRepository {
    suspend fun getCategories(): Resource<List<String>>
}