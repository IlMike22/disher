package com.example.disher.dishes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishes_table")
data class DishesResponse(
    @PrimaryKey var categoryId: String,
    val meals: List<Meal>
)

//TODO type converter