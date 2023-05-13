package com.example.disher.dishes.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.dishes.data.model.Meal
import com.example.disher.utils.presentation.SingleItem

@Composable
fun DishesScreen(
    viewModel: DishesViewModel = hiltViewModel(),
    category: String?,
    onDetailClick: (id: String) -> Unit
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
            Text(text = "Error ${(castedState.message)}")
        }

        is ViewState.Loading -> Text(text = "Loading")
        is ViewState.Success -> {
            DishesList(meals = castedState.data, onDetailClick)
        }
    }
}

@Composable
fun DishesList(
    meals: List<Meal>,
    onDetailClick: (id: String) -> Unit
) {
    LazyColumn() {
        items(meals) { meal ->
            SingleItem(
                title = meal.strMeal,
                thumbnail = meal.strMealThumb,
                onClick = { onDetailClick(meal.idMeal) }
            )
        }
    }
}