package com.example.myapplication.viewModel

import com.example.myapplication.model.models.Users

data class UsersDetails(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = ""
)

data class UsersUiState(
    val usersDetails: UsersDetails = UsersDetails(),
    val isEntryValid: Boolean = false
)

fun UsersDetails.toUsers(): Users = Users(
    id = id,
    name = name,
    email = email,
    phone = phone,
    password = password
)

fun Users.toUserDetails() = UsersDetails(
    id = id,
    name = name,
    email = email,
    phone = phone,
    password = password
)

fun Users.toUserUiState(isEntryValid: Boolean = false): UsersUiState = UsersUiState(
    usersDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)