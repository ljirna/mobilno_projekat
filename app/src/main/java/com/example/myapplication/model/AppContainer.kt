package com.example.myapplication.model

import android.content.Context
import com.example.myapplication.model.repositories.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}
class AppDataContainer(private val contex: Context): AppContainer{
    override val userRepository: UserRepository by lazy {
        UserRepository(AppDatabase.getDatabase(contex).usersDao())
    }
}

