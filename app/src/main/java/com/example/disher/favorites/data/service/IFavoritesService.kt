package com.example.disher.favorites.data.service

import com.example.disher.detail.data.model.MealDetail

interface IFavoritesService {
    suspend fun getFavorites(): List<MealDetail>
}