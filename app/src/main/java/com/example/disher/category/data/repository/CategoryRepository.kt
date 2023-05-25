package com.example.disher.category.data.repository

import com.example.disher.category.data.model.CategoryResponse
import com.example.disher.category.data.service.ICategoryService
import com.example.disher.category.domain.repository.ICategoryRepository
import com.example.disher.db.IDisherDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val service: ICategoryService,
    private val dao: IDisherDao,
    private val ioDispatcher: CoroutineDispatcher,
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return withContext(ioDispatcher) {
            try {
                val response = service.getCategories()
                dao.saveCategoryResponse(response.categories)
                response
            } catch (exception: Exception) {
                CategoryResponse(dao.getCategories())
            }
        }
    }
}