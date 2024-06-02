package com.example.myapplication.model.repositories

import com.example.myapplication.model.daos.FavouritesDao
import com.example.myapplication.model.models.Favourites
import kotlinx.coroutines.flow.Flow

class FavouritesRepository (private val favouritesDao: FavouritesDao) : BaseRepository<Favourites> {
    override suspend fun insert(t: Favourites) = favouritesDao.insert(t)

    override suspend fun update(t: Favourites) = favouritesDao.update(t)
    override suspend fun delete(t: Favourites) = favouritesDao.delete(t)

    override fun getOneStream(id: Int): Flow<Favourites?> = favouritesDao.getFavourite(id)

    fun getFavourites(): Flow<List<Favourites>> = favouritesDao.getFavourites()

    fun getFavouriteBySalonId(salonId: Int, userId: Int) = favouritesDao.getFavouritesBySalonId(salonId, userId)

    fun deleteFavouriteBySalonId(salonId: Int, userId: Int) {
        favouritesDao.deleteFavouritesBySalonId(salonId, userId)
    }
}