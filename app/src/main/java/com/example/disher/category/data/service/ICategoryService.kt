package com.example.disher.category.data.service

import com.example.disher.category.data.model.CategoryResponse
import retrofit2.http.GET

interface ICategoryService {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}