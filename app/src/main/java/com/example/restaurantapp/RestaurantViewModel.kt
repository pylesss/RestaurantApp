package com.example.restaurantapp

import androidx.lifecycle.ViewModel
import com.example.restaurantapp.domain.dummyRestaurants

class RestaurantViewModel(): ViewModel() {

    fun getRestaurants() = dummyRestaurants


}