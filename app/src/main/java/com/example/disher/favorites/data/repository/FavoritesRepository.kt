package com.example.disher.favorites.data.repository

import com.example.disher.detail.data.model.MealDetail
import com.example.disher.favorites.data.service.IFavoritesService
import com.example.disher.favorites.domain.IFavoritesRepository
import javax.inject.Inject

class FavoritesRepository @Inject constructor(
    private val service: IFavoritesService
) : IFavoritesRepository {
    override suspend fun getFavorites(): List<MealDetail> {
        return service.getFavorites()
    }
}