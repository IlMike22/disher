package com.example.disher.detail.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.detail.data.model.DetailResponse
import com.example.disher.detail.domain.use_case.GetMealDetailAsFavoriteUseCase
import com.example.disher.detail.domain.use_case.IGetDetailsUseCase
import com.example.disher.detail.domain.use_case.IStoreToFavoritesUseCase
import com.example.disher.detail.presentation.MealDetailState
import com.example.disher.detail.presentation.model.DetailEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMealDetails: IGetDetailsUseCase,
    private val getMealDetailsAsFavorite: GetMealDetailAsFavoriteUseCase,
    private val storeMealDetailAsFavorite: IStoreToFavoritesUseCase
) : ViewModel() {
    private val _mealState: MutableState<MealDetailState> = mutableStateOf(MealDetailState())
    val mealState: State<MealDetailState> = _mealState

    private var _isInFavorites = MutableStateFlow<Boolean>(false)
    val isInFavorites = _isInFavorites.asStateFlow()

    fun getDetails(mealId: String) {
        _mealState.value = MealDetailState(isLoading = true)
        viewModelScope.launch {
            try {
                val remoteMealDetail: DetailResponse?
                val localMealDetail = getMealDetailsAsFavorite(mealId)
                if (localMealDetail == null) {
                    remoteMealDetail = getMealDetails(mealId)
                    _mealState.value = MealDetailState(
                        mealDetails = remoteMealDetail.meals.firstOrNull(),
                        isError = false,
                        isLoading = false
                    )
                    _isInFavorites.value = false
                } else {
                    _mealState.value = MealDetailState(
                        mealDetails = localMealDetail,
                        isError = false,
                        isLoading = false
                    )
                    _isInFavorites.value = true
                }

            } catch (exception: Exception) {
                _mealState.value = MealDetailState(
                    mealDetails = null,
                    isError = true,
                    isLoading = false
                )
            }
        }
    }

    fun onEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.OnFavoritesClicked -> {
                viewModelScope.launch {
                    event.mealDetail?.let {
                        storeMealDetailAsFavorite(it)
                    }
                    _isInFavorites.update { true }
                }
            }
        }
    }
}