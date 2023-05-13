package com.example.disher.detail.presentation

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.disher.detail.presentation.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    mealId: String
) {
    val state by remember { viewModel.mealState }

    DisposableEffect(key1 = Unit) {
        if (mealId.isNotBlank()) {
            viewModel.getDetails(mealId)
        }
        onDispose {}
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        if (state.isLoading) {
            Text(text = "LOADING")
        } else if (state.isError) {
            Text(text = "ERROR", color = Color.Red)
        } else {
            Text(
                text = state.mealDetails?.strMeal ?: "",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row() {
                Text(
                    text = state.mealDetails?.strCategory ?: "",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = rememberAsyncImagePainter(state.mealDetails?.strMealThumb),
                    modifier = Modifier.size(40.dp),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = state.mealDetails?.strIngredient1 ?: "",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}