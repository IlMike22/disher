package com.example.disher.dishes.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column {
                    Text(text = "An error occurred", style = MaterialTheme.typography.headlineSmall)
                    Spacer(Modifier.height(32.dp))
                    Text(
                        text = "${(castedState.message)}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        is ViewState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

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
    Column() {
        Text(text = "Category Id: $")
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
}