package com.example.restaurantapp

import com.example.restaurantapp.domain.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantsApiService {
    @GET("restaurants.json")
    fun getRestaurants(): Call<List<Restaurant>>
}