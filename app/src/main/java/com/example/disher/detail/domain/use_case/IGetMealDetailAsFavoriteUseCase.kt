package com.example.disher.detail.domain.use_case

import com.example.disher.detail.data.model.MealDetail

interface IGetMealDetailAsFavoriteUseCase {
    suspend operator fun invoke(mealId: String): MealDetail?
}