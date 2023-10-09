package com.example.restaurantapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.restaurantapp.domain.Restaurant
import com.example.restaurantapp.viewmodel.RestaurantViewModel

@Composable
fun RestaurantsScreen(
    onItemClick: (id: Int) -> Unit = {}
) {
    val viewModel: RestaurantViewModel = viewModel()
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ){
        items(viewModel.state.value) { restaurant ->
            RestaurantItem(
                item = restaurant,
                onFavoriteClick = { id, oldValue ->
                    viewModel.toggleFavorite(id, oldValue)
                },
                onItemClick = { id ->
                    onItemClick(id)
                }
            )
        }
    }
}

@Composable
fun RestaurantItem(
    item: Restaurant,
    onFavoriteClick: (id: Int, oldValue: Boolean) -> Unit,
    onItemClick: (id: Int) -> Unit
) {
    val icon = if (item.isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemClick(item.id)
            }
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
            RestaurantIcon(
                icon = icon,
                modifier = Modifier.weight(0.15f)
            ) {
                onFavoriteClick(item.id, item.isFavorite)
            }
        }
    }
    
}

@Composable
fun RestaurantIcon(
    icon: ImageVector,
    modifier: Modifier,
    onClick: () -> Unit = {}
) {
    Image(
        imageVector = icon,
        contentDescription = "Restaurant icon",
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
    )
}

@Composable
fun RestaurantDetails(
    title: String,
    description: String,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment
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

//@Composable
//fun FavoriteIcon(
//    icon: ImageVector,
//    modifier: Modifier = Modifier,
//    onClick: () -> Unit = {}
//) {
//    Image(
//        imageVector = icon,
//        contentDescription = "Favorite restaurant icon",
//        modifier = modifier
//            .padding(8.dp)
//            .clickable { onClick() }
//    )
//}

//@Composable
//fun FavoriteButton(modifier: Modifier = Modifier) {
//    var favorite by remember { mutableStateOf(false) }
//    var color by remember { mutableStateOf(Color.Gray) }
//
//    color = if (favorite) {
//        Color.Red
//    } else {
//        Color.Gray
//    }
//
//    Image(
//        Icons.Default.Favorite,
//        contentDescription = null,
//        colorFilter = ColorFilter.tint(color),
//        modifier = modifier
//            .size(200.dp)
//            .clickable {
//                favorite = true
//                if (color == Color.Red) {
//                    favorite = false
//                }
//            }
//    )
//}

@Preview(showBackground = true)
@Composable
fun RestaurantPreview() {
    RestaurantsScreen()
}