package com.example.myapplication.model.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.models.Favourites
import com.example.myapplication.model.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favourites: Favourites)

    @Update
    suspend fun update(favourites: Favourites)

    @Delete
    suspend fun delete(favourites: Favourites)

    @Query("SELECT * FROM Favourites WHERE id = :id")
    fun getFavourite(id: Int): Flow<Favourites>

    @Query("SELECT * FROM Favourites")
    fun getFavourites(): Flow<List<Favourites>>

    @Query("SELECT * FROM Favourites WHERE userId = :userId")
    fun getFavouritesByUserId(userId: Int): Flow<List<Favourites?>>

    @Query("SELECT * FROM Favourites WHERE userId = :userId AND salonId = :salonId")
    fun getFavouritesByUserId(userId: Int, salonId: Int): Flow<List<Favourites?>>

    @Query("DELETE FROM Favourites WHERE salonId = :salonId AND userId = :userId")
    fun deleteFavouritesBySalonId(salonId: Int, userId: Int): Int

    @Query ("DELETE FROM Favourites WHERE salonId = :salonId")
    fun deleteFavourite(salonId: Int): Int

}