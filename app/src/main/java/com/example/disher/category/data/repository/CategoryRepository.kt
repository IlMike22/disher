package com.example.disher.category.data.repository

import com.example.disher.category.domain.repository.ICategoryRepository

class CategoryRepository:ICategoryRepository {
    override fun getAllCategories(): String {
        return "Page 42"
    }
}