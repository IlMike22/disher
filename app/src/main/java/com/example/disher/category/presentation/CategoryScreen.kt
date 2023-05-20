package com.example.disher.category.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.category.presentation.viewmodel.CategoryViewModel
import com.example.disher.utils.presentation.SingleItem

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel(),
    onShowFavoritesClick: () -> Unit,
    onItemClick: (String) -> Unit
) {
    val categories by remember { viewModel.categories }
    Column {
        Button(
            onClick = { onShowFavoritesClick() },
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text(text = "Show favorites")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(categories) { category ->
                SingleItem(
                    title = category.strCategory,
                    thumbnail = category.strCategoryThumb,
                    onClick = onItemClick
                )
            }
        }
    }
}