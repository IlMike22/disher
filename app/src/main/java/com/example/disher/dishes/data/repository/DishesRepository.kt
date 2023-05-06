package com.example.disher.dishes.data.repository

import com.example.disher.dishes.data.model.DishesResponse
import com.example.disher.dishes.data.service.IDishesService
import com.example.disher.dishes.domain.IDishesRepository
import javax.inject.Inject

class DishesRepository @Inject constructor(
    private val service: IDishesService
) : IDishesRepository {
    override suspend fun getDishes(categoryName: String): DishesResponse {
        return service.getDishesForCategory(categoryName)
    }
}