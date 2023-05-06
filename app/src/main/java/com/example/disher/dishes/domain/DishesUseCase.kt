package com.example.disher.dishes.domain

import com.example.disher.dishes.data.model.DishesResponse
import javax.inject.Inject

class GetDishesUseCase @Inject constructor(
    private val repository: IDishesRepository
) : IGetDishesUseCase {
    override suspend fun invoke(categoryName: String): DishesResponse {
        return repository.getDishes(categoryName)
    }
}