package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.FavoriteDao
import com.example.myapplication.database.FavoriteEntity
import com.example.myapplication.network.Recipes
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(private val favoriteDao: FavoriteDao):ViewModel() {

   fun showFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAll()

}