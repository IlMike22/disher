package com.example.disher.detail.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.disher.R
import com.example.disher.detail.presentation.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    mealId: String
) {
    val state by remember { viewModel.mealState }
    val uriHandler = LocalUriHandler.current

    DisposableEffect(key1 = Unit) {
        if (mealId.isNotBlank()) {
            viewModel.getDetails(mealId)
        }
        onDispose {}
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
            Row {
                Text(
                    text = state.mealDetails?.strCategory ?: "",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    painter = rememberAsyncImagePainter(state.mealDetails?.strMealThumb),
                    modifier = Modifier.size(40.dp),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(32.dp))
                Image(painterResource(
                    id = if (state.isInFavorites) R.drawable.ic_heart else R.drawable.ic_heart_outline
                ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            //TODO send event to vm (store it in database if not already exists)
                        }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = state.mealDetails?.strIngredient1 ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (state.mealDetails?.strYoutube != null) {
                ClickableText(
                    style = MaterialTheme.typography.bodyMedium,
                    text = AnnotatedString(text = "Find more info on Youtube"),
                    onClick = {
                        uriHandler.openUri(state.mealDetails?.strYoutube ?: "")
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            InstructionTextBlock(state.mealDetails?.strInstructions ?: "")
        }
    }
}

@Composable
fun InstructionTextBlock(
    instructions: String,
    modifier: Modifier = Modifier
) {
    var showMore by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .`if`(!showMore) {
                height(100.dp)
            }
        ) {
            Text(text = instructions, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { showMore = !showMore }) {
            Text(text = if (!showMore) "Show more..." else "Show less..")
        }
    }
}

fun Modifier.`if`(
    condition: Boolean,
    then: Modifier.() -> Modifier
): Modifier =
    if (condition) {
        then()
    } else {
        this
    }