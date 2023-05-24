package com.example.disher.category.data.model

import androidx.room.Entity
import androidx.room.TypeConverter


data class CategoryResponse(
    val categories: List<Category>
)

//class CategoryConverter {
//    @TypeConverter
//    fun listOfCategoryToString(categories: List<Category>): String? {
//        categories.map {
//            "${it.idCategory}---${it.strCategory}---$it.
//        }
//    }

//    @TypeConverter
//    fun
//}