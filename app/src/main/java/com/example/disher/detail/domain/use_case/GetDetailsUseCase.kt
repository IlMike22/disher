package com.example.disher.detail.domain.use_case

import com.example.disher.detail.data.model.DetailResponse
import com.example.disher.detail.domain.repository.IDetailRepository
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(
    private val repository: IDetailRepository
) : IGetDetailsUseCase {
    override suspend operator fun invoke(mealId: String): DetailResponse {
        return repository.getMealDetail(mealId)
    }
}