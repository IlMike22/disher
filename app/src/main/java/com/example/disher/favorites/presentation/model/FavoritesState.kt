package com.example.disher.favorites.presentation.model

import com.example.disher.detail.data.model.MealDetail

data class FavoritesState(
    val mealDetails: List<MealDetail> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)