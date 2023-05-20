package com.example.disher.detail.presentation.model

import com.example.disher.detail.data.model.MealDetail

sealed interface DetailEvent {
    data class OnFavoritesClicked(val mealDetail: MealDetail?) : DetailEvent
}
