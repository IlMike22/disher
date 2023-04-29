package com.example.disher.category.domain.use_case

import com.example.disher.category.domain.repository.ICategoryRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: ICategoryRepository
) : IGetCategoriesUseCase {
    override fun invoke(): String {
        return repository.getAllCategories()
    }
}