package com.example.disher.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.disher.detail.data.model.MealDetail

@Dao
interface IDisherDao {
    @Insert
    suspend fun insertMeal(mealDetail: MealDetail)

    @Query("SELECT * FROM meal_details")
    suspend fun getMealDetails(): List<MealDetail>
}