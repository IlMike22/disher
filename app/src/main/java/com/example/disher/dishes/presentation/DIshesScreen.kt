package com.example.disher.dishes.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DishesScreen(
    category: String
) {
    Text(text = "Dishes here! Category is $category")
}