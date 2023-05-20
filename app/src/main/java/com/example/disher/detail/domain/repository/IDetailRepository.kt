package com.example.disher.detail.domain.repository

import com.example.disher.detail.data.model.DetailResponse
import com.example.disher.detail.data.model.MealDetail

interface IDetailRepository {
    suspend fun getMealDetail(mealId: String): DetailResponse
    suspend fun storeMealToFavorites(mealDetail: MealDetail)
}