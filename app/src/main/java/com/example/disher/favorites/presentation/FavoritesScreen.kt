package com.example.disher.favorites.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.disher.R
import com.example.disher.favorites.presentation.model.FavoritesState

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    state: FavoritesState
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.favorites_title),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(16.dp))
        if (state.isError) {
            Text(text = stringResource(R.string.favorites_error_text))
        } else if (state.isLoading) {
            Text(text = stringResource(R.string.favorites_loading))
        } else if (state.mealDetails.isNotEmpty()) {
            LazyColumn() {
                items(state.mealDetails) {
                    Text(
                        text = it.strMeal
                            ?: stringResource(R.string.favorites_error_text_no_id_found)
                    )
                    Spacer(Modifier.height(4.dp))
                }
            }
        }
    }
}