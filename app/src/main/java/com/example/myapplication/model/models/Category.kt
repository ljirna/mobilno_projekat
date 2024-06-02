package com.example.myapplication.model.models

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey (autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "image")
    @DrawableRes var image: Int,

    @ColumnInfo(name = "title")
    val title: String
)