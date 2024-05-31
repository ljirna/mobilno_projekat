package com.example.myapplication.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.daos.UsersDao
import com.example.myapplication.model.models.Users
import perfetto.protos.ProfilerSmaps

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun usersDao(): UsersDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(context, AppDatabase::class.java, "APPDatabase")
                    .build().also { INSTANCE = it}
            }
        }
    }
}