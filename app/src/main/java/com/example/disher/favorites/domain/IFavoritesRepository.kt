package com.example.disher.favorites.domain

import com.example.disher.detail.data.model.MealDetail

interface IFavoritesRepository {
    suspend fun getFavorites(): List<MealDetail>
}