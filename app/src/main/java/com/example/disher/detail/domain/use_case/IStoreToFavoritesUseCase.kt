package com.example.disher.detail.domain.use_case

import com.example.disher.detail.data.model.MealDetail

interface IStoreToFavoritesUseCase {
    suspend operator fun invoke(mealDetail:MealDetail)
}