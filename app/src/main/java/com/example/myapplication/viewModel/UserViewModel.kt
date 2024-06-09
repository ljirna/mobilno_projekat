package com.example.myapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.repositories.UserRepository
import com.example.myapplication.screens.HomeDestination
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UserViewModel (private val userRepository: UserRepository,
                     savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val userId: Int = checkNotNull(savedStateHandle[HomeDestination.userIdArg])

    var userUiState by mutableStateOf(UsersUiState())
        private set

    init {
        viewModelScope.launch {
            userUiState = userRepository.getOneStream(userId)
                .filterNotNull()
                .first()
                .toUserUiState(true)
        }
    }

    suspend fun updateUser(){
        userRepository.update(userUiState.usersDetails.toUsers())
    }

    // for logut

    fun clearUi() {
        userUiState = UsersUiState()
    }

    fun updateUiState(usersDetails: UsersDetails) {
        userUiState = UsersUiState(usersDetails = usersDetails, isEntryValid = false)
    }
}