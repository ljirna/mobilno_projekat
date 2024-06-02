package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.repositories.FavouritesRepository
import com.example.myapplication.model.repositories.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel (
    private val userRepository: UserRepository,
    private val fovouriteRepository: FavouritesRepository
) : ViewModel(){
    var userUistate by mutableStateOf(UsersUiState())
        private set

    var favouriteUiState by mutableStateOf(FavouritesUiState())
        private set

    var likesUiState by mutableStateOf(FavouritesUiState())
        private set

    fun getUserData(id: Int){
        viewModelScope.launch {
            userRepository.getOneStream(id).collect() {
                    user ->
                user?.let {
                    userUistate = user.toUserUiState()
                }
            }
        }
    }

    fun logout(onLogout: () -> Unit) {
        userUistate = UsersUiState()
        favouriteUiState = FavouritesUiState()
        onLogout()
    }

    fun fetchLikes(userId: Int, salonId: Int) {
        viewModelScope.launch {
            fovouriteRepository.getFavouriteBySalonId(salonId, userId).collect()
            {
                    favourite ->
                favourite?.let {
                    favouriteUiState = it.toFavouritesUiState()
                }
            }
        }
    }
}