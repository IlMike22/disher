package com.example.disher.category.domain.use_case

import com.example.disher.category.data.model.CategoryResponse

interface IGetCategoriesUseCase {
    suspend operator fun invoke(): CategoryResponse
}