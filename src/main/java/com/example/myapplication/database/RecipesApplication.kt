package com.example.myapplication.database

import android.app.Application

class RecipesApplication : Application(){
    val database: FavoriteDatabase by lazy { FavoriteDatabase.getInstance(this) }
}