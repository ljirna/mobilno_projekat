package com.example.myapplication.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(users: Users)

    @Update
    suspend fun update(users: Users)

    @Delete
    suspend fun delete(users: Users)

    @Query("SELECT * FROM Users WHERE id = :id")
    fun getUser(id: Int): Flow<Users>

    @Query("SELECT * FROM Users")
    fun getAllUsers(): Flow<List<Users>>

    @Query("SELECT * FROM Users WHERE email = :email")
    fun getUserByEmail(email: String): Flow<Users?>

    @Query("SELECT * FROM Users WHERE email = :email AND password = :password")
    fun login(email: String, password: String): Flow<Users?>

}
