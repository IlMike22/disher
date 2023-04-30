package com.example.disher.category.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.disher.category.data.model.Category
import com.example.disher.category.presentation.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categories by remember { viewModel.categories }
    Text(text = "Category")
    Spacer(modifier = Modifier.height(16.dp))
    LazyColumn() {
        items(categories) { category ->
            SingleCategoryItem(category = category)
        }
    }
}

@Composable
fun SingleCategoryItem(
    category: Category
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                modifier = Modifier.size(40.dp),
                contentDescription = null
            )
            Text(
                text = category.strCategory,
                modifier = Modifier.padding(8.dp),
                fontSize = 24.sp
            )
        }
    }
}