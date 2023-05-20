package com.example.disher.favorites.domain

import com.example.disher.detail.data.model.MealDetail
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: IFavoritesRepository
) {
    suspend operator fun invoke(): List<MealDetail> {
        return repository.getFavorites()
    }
}