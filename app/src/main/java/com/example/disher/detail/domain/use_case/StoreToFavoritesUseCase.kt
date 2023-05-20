package com.example.disher.detail.domain.use_case

import com.example.disher.detail.data.model.MealDetail
import com.example.disher.detail.domain.repository.IDetailRepository
import javax.inject.Inject

class StoreToFavoritesUseCase @Inject constructor(
    private val repository: IDetailRepository
) : IStoreToFavoritesUseCase {
    override suspend fun invoke(mealDetail: MealDetail) {
        repository.storeMealToFavorites(mealDetail)
    }
}