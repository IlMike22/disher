package com.example.disher.detail.data.repository

import com.example.disher.detail.data.model.DetailResponse
import com.example.disher.detail.data.service.IDetailService
import com.example.disher.detail.domain.repository.IDetailRepository
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val detailService: IDetailService
) : IDetailRepository {
    override suspend fun getMealDetail(mealId: String): DetailResponse {
        return detailService.getDetailsForDish(mealId)
    }
}