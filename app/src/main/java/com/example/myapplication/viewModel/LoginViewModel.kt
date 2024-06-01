package com.example.myapplication.viewModel
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.myapplication.model.repositories.UserRepository
import kotlinx.coroutines.flow.first


class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    var userUiState by mutableStateOf(UsersUiState())
        private set

    fun updateEmail(newEmail: String) {
        val updatedDetails = userUiState.usersDetails.copy(email = newEmail)
        userUiState = userUiState.copy(usersDetails = updatedDetails)
    }

    fun updatePassword(newPassword: String) {
        val updatedDetails = userUiState.usersDetails.copy(password = newPassword)
        userUiState = userUiState.copy(usersDetails = updatedDetails)
    }

    fun validateInput(): Boolean {
        return userUiState.usersDetails.email.isNotBlank() && userUiState.usersDetails.password.isNotBlank()
    }

    suspend fun signInUser(onResult: (Boolean, String?) -> Unit) {
        if (validateInput()) {
            val user = userRepository.login(userUiState.usersDetails.email, userUiState.usersDetails.password).first()
            if (user != null) {
                onResult(true, null)
            } else {
                onResult(false, "Invalid email or password")
            }
        } else {
            onResult(false, "Please enter both email and password")
        }
    }
}
