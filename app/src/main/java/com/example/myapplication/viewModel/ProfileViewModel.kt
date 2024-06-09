package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.models.Favourites
import com.example.myapplication.model.repositories.FavouritesRepository
import com.example.myapplication.model.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProfileViewModel (
    private val userRepository: UserRepository,
    private val favouriteRepository: FavouritesRepository
) : ViewModel(){
    var userUistate by mutableStateOf(UsersUiState())
        private set

    var favouriteUiState by mutableStateOf(FavouritesUiState())
        private set

   /* var likesUiState by mutableStateOf(FavouritesUiState())
        private set*/

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

    fun getFavouriteList(userId: Int) : Flow<List<Favourites?>>{
        return favouriteRepository.getFavouriteByUserId(userId)
    }

    fun deleteFavoriteBySalonId(salonId: Int) {
        viewModelScope.launch {
            favouriteRepository.deleteFavourite(salonId)
        }
    }

}