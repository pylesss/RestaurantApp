package com.example.restaurantapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restaurantapp.RestaurantViewModel
import com.example.restaurantapp.domain.Restaurant

@Composable
fun RestaurantScreen() {
    val viewModel: RestaurantViewModel = viewModel()
    val state =  remember { mutableStateOf("") }
    state.value = ""
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ){
        items(viewModel.getRestaurants()) { restaurant ->
            RestaurantItem(item = restaurant)
        }
    }
}

@Composable
fun RestaurantItem(
    item: Restaurant
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            RestaurantIcon(
                icon = Icons.Filled.Place,
                modifier = Modifier.weight(0.15f)
            )
            RestaurantDetails(
                title = item.title,
                description = item.description,
                modifier = Modifier.weight(0.7f)
            )
            FavoriteIcon(modifier = Modifier.weight(0.15f))
        }
    }
    
}

@Composable
fun RestaurantIcon(
    icon: ImageVector,
    modifier: Modifier
) {
    Image(
        imageVector = icon,
        contentDescription = "Restaurant icon",
        modifier = modifier.padding(8.dp)
    )
}

@Composable
fun RestaurantDetails(
    title: String,
    description: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun FavoriteIcon(modifier: Modifier = Modifier) {
    Image(
        imageVector = Icons.Filled.FavoriteBorder,
        contentDescription = "Favorite restaurant icon",
        modifier = modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RestaurantPreview() {
    RestaurantScreen()
}