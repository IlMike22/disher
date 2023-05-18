package com.example.disher.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disher.detail.data.model.MealDetail

@Database(
    entities = [MealDetail::class],
    version = 1
)
abstract class DisherDatabase : RoomDatabase() {
    abstract fun getDisherDao(): IDisherDao

}