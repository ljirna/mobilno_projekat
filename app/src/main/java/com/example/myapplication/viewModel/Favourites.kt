package com.example.myapplication.viewModel

import com.example.myapplication.model.models.Favourites

data class FavouritesDetails(
    val id: Int = 0,
    val userId: Int = 0,
    val salonId: Int = 0
)

data class FavouritesUiState(
    val favouritesDetails: FavouritesDetails = FavouritesDetails(),
    val isEntryValid: Boolean = false
)

fun FavouritesDetails.toFavourites(): Favourites = Favourites(
    id = id,
    userId = userId,
    salonId = salonId
)

fun Favourites.toFavouritesDetails() = FavouritesDetails(
    id = id,
    userId = userId,
    salonId = salonId
)

fun Favourites.toFavouritesUiState(isEntryValid: Boolean = false): FavouritesUiState = FavouritesUiState(
    favouritesDetails = this.toFavouritesDetails(),
    isEntryValid = isEntryValid
)