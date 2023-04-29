package com.example.disher.category.data.repository

import com.example.disher.category.data.model.CategoryResponse
import com.example.disher.category.data.service.ICategoryService
import com.example.disher.category.domain.repository.ICategoryRepository
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val service: ICategoryService
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getCategories()
    }
}