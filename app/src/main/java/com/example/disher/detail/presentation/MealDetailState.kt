package com.example.disher.detail.presentation

import com.example.disher.detail.data.model.MealDetail

data class MealDetailState(
    val mealDetails: MealDetail? = null,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)
