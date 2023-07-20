package com.example.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.restaurantapp.coroutines.MainScreen
import com.example.restaurantapp.coroutines.MainViewModel
import com.example.restaurantapp.ui.RestaurantScreen
import com.example.restaurantapp.ui.theme.RestaurantAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RestaurantScreen()
//                    MainScreen(viewModel)
                }
            }
        }
    }
}