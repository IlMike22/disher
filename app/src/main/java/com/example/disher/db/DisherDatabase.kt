package com.example.disher.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disher.detail.data.model.MealDetail

@Database(
    entities = [MealDetail::class],
    version = 1,
    exportSchema = false
)
abstract class DisherDatabase : RoomDatabase() {
    abstract fun getDisherDao(): IDisherDao

}