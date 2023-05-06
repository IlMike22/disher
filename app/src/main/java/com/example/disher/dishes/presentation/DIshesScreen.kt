package com.example.disher.dishes.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DishesScreen(
    viewModel: DishesViewModel = hiltViewModel(),
    category: String?
) {
    val state by remember { viewModel.viewState }

    DisposableEffect(key1 = Unit) {
        if (!category.isNullOrBlank()) {
            viewModel.getMealsForCategory(category)
        }
        onDispose {}
    }

    when (val castedState = state) {
        is ViewState.Error -> {
            Text(text = "Error ${(castedState.message)}") //Why needs casting?
        }

        is ViewState.Loading -> Text(text = "Loading")
        is ViewState.Success -> {
            Text(text = "Success ${castedState.data}")
        }
    }
}