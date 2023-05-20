package com.example.disher.detail.domain.use_case

import com.example.disher.detail.data.model.MealDetail
import com.example.disher.detail.domain.repository.IDetailRepository
import javax.inject.Inject

class GetMealDetailAsFavoriteUseCase @Inject constructor(
    private val repository: IDetailRepository
) : IGetMealDetailAsFavoriteUseCase {
    override suspend fun invoke(mealId: String): MealDetail? {
        return repository.getMealDetailFromFavorites(mealId)
    }
}