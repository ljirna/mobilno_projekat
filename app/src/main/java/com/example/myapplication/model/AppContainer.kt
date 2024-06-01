package com.example.myapplication.model

import android.content.Context
import com.example.myapplication.model.repositories.UserRepository
import com.example.myapplication.model.repositories.FavouritesRepository

interface AppContainer {
    val userRepository: UserRepository
    val favouritesRepository: FavouritesRepository
}
class AppDataContainer(private val contex: Context): AppContainer{
    override val userRepository: UserRepository by lazy {
        UserRepository(AppDatabase.getDatabase(contex).usersDao())
    }
    override val favouritesRepository: FavouritesRepository by lazy {
        FavouritesRepository(AppDatabase.getDatabase(contex).favouritesDao())
    }
}

