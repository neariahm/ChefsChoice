package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteList") //tableName not required in Codelab, why?
data class FavoriteEntity (
    //automatically creates a unique id for each recipe //can add Int = 0;
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "recipe_name") val title: String,
    @ColumnInfo(name = "image_url") val image: String,
   @ColumnInfo(name = "favorite") val favorite: Boolean,

    )
