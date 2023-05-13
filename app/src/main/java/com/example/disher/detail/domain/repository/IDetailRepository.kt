package com.example.disher.detail.domain.repository

import com.example.disher.detail.data.model.DetailResponse

interface IDetailRepository {
    suspend fun getMealDetail(mealId: String): DetailResponse
}