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

    fun getFavouriteList(userId: Int) : Flow<List<Favourites?>>{
        return fovouriteRepository.getFavouriteByUserId(userId)
    }



    fun editName (newName: String) {
        val updatedName = userUistate.usersDetails.copy(name = newName)
        userUistate = userUistate.copy(usersDetails = updatedName)
    }

    fun editEmail(newEmail: String) {
        val updatedEmail = userUistate.usersDetails.copy(email = newEmail)
        userUistate = userUistate.copy(usersDetails = updatedEmail)
    }
    fun editPhone(newPhone: String) {
        val updatedPhone = userUistate.usersDetails.copy(phone = newPhone)
        userUistate = userUistate.copy(usersDetails = updatedPhone)
    }

    fun saveChanges(onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                userRepository.update(userUistate.usersDetails.toUsers())
                onResult(true, null)
            } catch (e: Exception) {
                onResult(false, e.message ?: "Unknown error")
            }
        }
    }
}