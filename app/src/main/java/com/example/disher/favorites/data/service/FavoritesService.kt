package com.example.disher.favorites.data.service

import com.example.disher.db.IDisherDao
import com.example.disher.detail.data.model.MealDetail

class FavoritesService(
    private val dao: IDisherDao
) : IFavoritesService {
    override suspend fun getFavorites(): List<MealDetail> {
        return dao.getMealDetails()
    }
}