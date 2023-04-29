package com.example.disher.category.domain.repository

import com.example.disher.category.data.model.CategoryResponse

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse

}