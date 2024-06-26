package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.AppApplication


object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            LoginSignUpViewModel(
                appApplication().container.userRepository
            )
        }
        initializer {
            UserViewModel(
                appApplication().container.userRepository,
                this.createSavedStateHandle()
            )
        }
        initializer {
            ProfileViewModel(
                appApplication().container.favouritesRepository
            )
        }
        initializer {
            SalonFavoritesViewModel(
                appApplication().container.favouritesRepository
            )
        }
}

fun CreationExtras.appApplication(): AppApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AppApplication)}