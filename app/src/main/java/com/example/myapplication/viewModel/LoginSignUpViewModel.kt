package com.example.myapplication.viewModel
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.myapplication.model.repositories.UserRepository
import kotlinx.coroutines.flow.first


class LoginSignUpViewModel(private val userRepository: UserRepository) : ViewModel() {
    var userUiState by mutableStateOf(UsersUiState())
        private set

    suspend fun register(): Boolean {
        if(validateInput()) {
            userRepository.insert(userUiState.usersDetails.toUsers())
            login();
            return true
        } else return false
    }

    private suspend fun validateInput(uiState: UsersDetails = userUiState.usersDetails): Boolean {
        return with(uiState) {
            checkEmail()
        }
    }
    private suspend fun checkEmail() :Boolean {
        return userRepository.getEmailUser(userUiState.usersDetails.email).first()
            ?.toUserUiState()?.usersDetails?.email?.isEmpty()?: true
    }

    suspend fun login(): Boolean {
        val res = userRepository.login(userUiState.usersDetails.password, userUiState.usersDetails.email)
            .first()
            ?.toUserUiState(true)

        if (res != null) {
            userUiState = res
            return true
        } else {
            return false
        }
    }

    fun updateUiState (usersDetails: UsersDetails) {
        userUiState = UsersUiState(usersDetails = usersDetails, isEntryValid = false)
    }
}
