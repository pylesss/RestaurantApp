package com.example.restaurantapp.network

import com.example.restaurantapp.domain.Restaurant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantsApiService {
    @GET("restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>

    @GET("restaurants.json?orderBy=\"r_id\"")
    suspend fun getRestaurant( @Query("equalTo") id: Int): Map<String, Restaurant>
}