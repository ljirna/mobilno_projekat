package com.example.myapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.repositories.UserRepository

class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {
    var userUiState by mutableStateOf(UsersUiState())
        private set


    fun updateUiState(usersDetails: UsersDetails) {
        userUiState =
            UsersUiState(usersDetails = usersDetails, isEntryValid = false)
    }
}
