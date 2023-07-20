package com.example.restaurantapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.restaurantapp.domain.dummyRestaurants

class RestaurantViewModel(): ViewModel() {

    val state = mutableStateOf(dummyRestaurants)

    fun toggleFavorite(id: Int) {
        val restaurants = state.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst { it.id == id }
        val item = restaurants[itemIndex]
        restaurants[itemIndex] = item.copy( isFavorite = !item.isFavorite)
        state.value = restaurants
    }
}