package com.example.disher.detail.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.detail.domain.use_case.IGetDetailsUseCase
import com.example.disher.detail.presentation.MealDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMealDetails: IGetDetailsUseCase
) : ViewModel() {
    private val _mealState: MutableState<MealDetailState> = mutableStateOf(MealDetailState())
    val mealState: State<MealDetailState> = _mealState

    fun getDetails(mealId: String) {
        _mealState.value = MealDetailState(isLoading = true)
        viewModelScope.launch {
            try {
                val response = getMealDetails(mealId)
                _mealState.value = MealDetailState(
                    mealDetails = response.meals?.firstOrNull(),
                    isError = false,
                    isLoading = false
                )
            } catch (exception: Exception) {
                _mealState.value = MealDetailState(
                    mealDetails = null,
                    isError = true,
                    isLoading = false
                )
            }
        }
    }
}