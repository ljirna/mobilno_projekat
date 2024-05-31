package com.example.myapplication.model.repositories

import com.example.myapplication.model.daos.UsersDao
import com.example.myapplication.model.models.Users
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao: UsersDao): BaseRepository<Users> {
    override suspend fun insert(t: Users) = userDao.insert(t)

    // Implement the update method
    override suspend fun update(t: Users) = userDao.update(t)

    override suspend fun delete(t: Users) = userDao.delete(t)

    override fun getOneStream(id: Int): Flow<Users?> = userDao.getUser(id)

    fun getAllUsers(): Flow<List<Users>> = userDao.getAllUsers()

    suspend fun getEmailUser(email: String) = userDao.getUserByEmail(email)

}