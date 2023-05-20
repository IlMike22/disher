package com.example.disher.favorites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.favorites.domain.GetFavoritesUseCase
import com.example.disher.favorites.presentation.model.FavoritesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    val getFavorites: GetFavoritesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(FavoritesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true, isError = false, mealDetails = emptyList())
            }
            try {
                val details = getFavorites()
                _state.update {
                    it.copy(
                        isError = false,
                        isLoading = false,
                        mealDetails = details
                    )
                }

            } catch (exception: Exception) {
                _state.update { it.copy(isError = true, isLoading = false) }
            }
        }
    }
}