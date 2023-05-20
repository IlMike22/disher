package com.example.disher.favorites.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.disher.favorites.presentation.model.FavoritesState

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    state: FavoritesState
) {
    Column() {
        Text(text = "Hello Favorites")
        Spacer(Modifier.height(16.dp))
        if (state.isError) {
            Text(text = "Unfortunately an error occured :/")
        } else if (state.isLoading) {
            Text(text = "Loading the favorites...")
        } else if (state.mealDetails.isNotEmpty()) {
            LazyColumn() {
                items(state.mealDetails) {
                    Text(text = it.strMeal ?: "No Str Meal found..")
                    Spacer(Modifier.height(4.dp))
                }
            }
        }
    }
}