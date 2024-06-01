package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.AppApplication


object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            SignupViewModel(
                appApplication().container.userRepository
            )
        }
        initializer {
            LoginViewModel(
                appApplication().container.userRepository
            )
        }
        initializer {
            ProfileViewModel(
                appApplication().container.userRepository
            )
        }
    }
}

fun CreationExtras.appApplication(): AppApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AppApplication)