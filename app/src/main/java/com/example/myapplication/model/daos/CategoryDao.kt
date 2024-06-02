package com.example.myapplication.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.models.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (category: Category)

    @Update
    suspend fun update (category: Category)

    @Delete
    suspend fun delete (category: Category)

    @Query("SELECT * FROM Category WHERE id = :id")
    fun getCategory(id: Int): Flow<Category>

    @Query("SELECT * FROM Category")
    fun getAllCategories(): Flow<List<Category>>
}