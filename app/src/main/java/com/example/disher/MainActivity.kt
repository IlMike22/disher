package com.example.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.disher.category.presentation.CategoryScreen
import com.example.disher.dishes.presentation.DishesScreen
import com.example.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                // A surface container using the 'background' color from the theme
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
            CategoryScreen() {

            }
        }

        composable("dishes") {
            DishesScreen()
        }
    }
}