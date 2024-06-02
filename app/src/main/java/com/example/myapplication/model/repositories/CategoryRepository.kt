package com.example.myapplication.model.repositories

import com.example.myapplication.model.daos.CategoryDao
import com.example.myapplication.model.models.Category

class CategoryRepository (private val categoryDao: CategoryDao): BaseRepository<Category> {
    override suspend fun insert(t: Category) = categoryDao.insert(t)
    override suspend fun update(t: Category) = categoryDao.update(t)
    override suspend fun delete(t: Category) = categoryDao.delete(t)
    override fun getOneStream(id: Int) = categoryDao.getCategory(id)
    fun getAllCategories() = categoryDao.getAllCategories()
}