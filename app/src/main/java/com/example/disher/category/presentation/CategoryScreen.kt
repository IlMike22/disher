package com.example.disher.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.category.presentation.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categories = getFakeData()
    Column {
        Text(text = "Category")
        Spacer(modifier = Modifier.height(16.dp))
        categories.forEach {
            Text(text = it)
        }
    }
}

fun getFakeData(): List<String> {
    return listOf(
        "Fish",
        "Vegan",
        "Meat"
    )
}