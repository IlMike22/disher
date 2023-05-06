package com.example.disher.dishes.presentation

import com.example.disher.dishes.data.model.Meal

sealed interface ViewState {
    data class Loading(val isLoading: Boolean) : ViewState
    data class Success(val data: List<Meal>) : ViewState
    data class Error(val message: String?) : ViewState
}
