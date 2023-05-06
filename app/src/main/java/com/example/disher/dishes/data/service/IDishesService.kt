package com.example.disher.dishes.data.service

import com.example.disher.category.data.model.Category
import com.example.disher.dishes.data.model.DishesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDishesService {
    @GET("filter.php")
    suspend fun getDishesForCategory(
        @Query("c") category: String
    ): DishesResponse
}