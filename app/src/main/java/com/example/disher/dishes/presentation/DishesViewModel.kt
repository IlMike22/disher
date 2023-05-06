package com.example.disher.dishes.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.dishes.domain.IGetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val getDishes: IGetDishesUseCase
) : ViewModel() {
    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading(true))
    val viewState: State<ViewState> = _viewState

    fun getMealsForCategory(categoryName: String) {
        _viewState.value = ViewState.Loading(true)
        viewModelScope.launch {
            try {
                _viewState.value = ViewState.Loading(false)
                val dishes = getDishes(categoryName)
                _viewState.value = ViewState.Success(dishes.meals)
            } catch (exception: Exception) {
                _viewState.value = ViewState.Loading(false)
                Log.d("BK", "Exception ${exception.message}")
                _viewState.value = ViewState.Error(exception.message ?: "Unknown error.")
            }
        }
    }
}