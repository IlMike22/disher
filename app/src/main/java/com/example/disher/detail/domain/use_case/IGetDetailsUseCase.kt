package com.example.disher.detail.domain.use_case

import com.example.disher.detail.data.model.DetailResponse

interface IGetDetailsUseCase {
    suspend operator fun invoke(mealId: String): DetailResponse
}