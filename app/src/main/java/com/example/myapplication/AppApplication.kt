package com.example.myapplication

import android.app.Application
import com.example.myapplication.model.AppContainer
import com.example.myapplication.model.AppDataContainer

class AppApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}