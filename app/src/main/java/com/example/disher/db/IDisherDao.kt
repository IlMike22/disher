package com.example.disher.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.disher.category.data.model.Category
import com.example.disher.category.data.model.CategoryResponse
import com.example.disher.detail.data.model.MealDetail

@Dao
interface IDisherDao {
    @Insert
    suspend fun insertMeal(mealDetail: MealDetail)

    @Query("SELECT * FROM meal_details")
    suspend fun getMealDetails(): List<MealDetail>

    @Query("SELECT * FROM meal_details WHERE idMeal = :mealId")
    suspend fun getMealDetailFromId(mealId: String): MealDetail?

    @Query("SELECT * FROM categories")
    suspend fun getCategories(): List<Category>

    @Insert(onConflict = REPLACE)
    suspend fun saveCategoryResponse(categories:List<Category>)

}