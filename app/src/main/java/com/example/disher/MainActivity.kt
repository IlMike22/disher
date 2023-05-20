package com.example.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.disher.category.presentation.CategoryScreen
import com.example.disher.detail.presentation.DetailScreen
import com.example.disher.detail.presentation.viewmodel.DetailViewModel
import com.example.disher.dishes.presentation.DishesScreen
import com.example.disher.favorites.presentation.FavoritesScreen
import com.example.disher.favorites.presentation.viewmodel.FavoritesViewModel
import com.example.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}

@Composable
fun DisherApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable("category") {
            CategoryScreen(
                onShowFavoritesClick = { navController.navigate("favorites") },
                onItemClick = { navController.navigate("dishes/$it") }
            )
        }
        composable("dishes/{category}", arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
            }
        )) {
            val categoryString = remember {
                it.arguments?.getString("category")
            }

            DishesScreen(category = categoryString ?: "", onDetailClick = {
                navController.navigate("detail/$it")
            })
        }
        composable("detail/{mealId}", arguments = listOf(
            navArgument("mealId") {
                type = NavType.StringType
            }
        )) {
            val mealId = remember {
                it.arguments?.getString("mealId")
            }
            val viewModel = hiltViewModel<DetailViewModel>()
            val isInFavorites = viewModel.isInFavorites.collectAsState()
            DetailScreen(mealId = mealId ?: "", isInFavorites = isInFavorites)
        }
        composable("favorites") {
            val viewModel = hiltViewModel<FavoritesViewModel>()
            val state by viewModel.state.collectAsState()
            FavoritesScreen(
                state = state
            )
        }
    }
}