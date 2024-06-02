package com.example.myapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.models.Favourites
import com.example.myapplication.model.repositories.FavouritesRepository
import kotlinx.coroutines.launch

class SalonFavoritesViewModel (
    private val favouriteRepository: FavouritesRepository): ViewModel(){
    var favouriteUiState by mutableStateOf(FavouritesUiState())
        private set

    var updatedUiState by mutableStateOf(FavouritesUiState())
        private set

    fun insertFavorite(salonId: Int, userId: Int) {
        viewModelScope.launch {
            val favourite = Favourites(salonId = salonId, userId = userId)
            favouriteRepository.insert(favourite)
            // Update UI state if needed
        }
    }
    fun deleteFavorite(salonId: Int, userId: Int) {
        viewModelScope.launch {
            favouriteRepository.deleteFavouriteBySalonId(salonId, userId)
        }
    }

    fun isFavourite(salonId: Int, userId: Int, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val favourite = favouriteRepository.getFavouriteBySalonId(salonId, userId)
            onResult(favourite != null)
        }
    }
}