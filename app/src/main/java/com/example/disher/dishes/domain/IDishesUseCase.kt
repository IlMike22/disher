package com.example.disher.dishes.domain

import com.example.disher.dishes.data.model.DishesResponse

interface IGetDishesUseCase {
    suspend operator fun invoke(categoryName: String): DishesResponse
}