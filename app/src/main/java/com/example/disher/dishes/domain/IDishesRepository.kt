package com.example.disher.dishes.domain

import com.example.disher.dishes.data.model.DishesResponse

interface IDishesRepository {
    suspend fun getDishes(categoryName: String): DishesResponse
}