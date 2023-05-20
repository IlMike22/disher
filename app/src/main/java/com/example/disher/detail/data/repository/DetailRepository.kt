package com.example.disher.detail.data.repository

import com.example.disher.db.IDisherDao
import com.example.disher.detail.data.model.DetailResponse
import com.example.disher.detail.data.model.MealDetail
import com.example.disher.detail.data.service.IDetailService
import com.example.disher.detail.domain.repository.IDetailRepository
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val detailService: IDetailService,
    private val dao: IDisherDao
) : IDetailRepository {
    override suspend fun getMealDetail(mealId: String): DetailResponse {
        return detailService.getDetailsForDish(mealId)
    }

    override suspend fun storeMealToFavorites(mealDetail: MealDetail) {
        dao.insertMeal(mealDetail) // TODO MIC not so nice writing in DB directly from REPO
    }
}