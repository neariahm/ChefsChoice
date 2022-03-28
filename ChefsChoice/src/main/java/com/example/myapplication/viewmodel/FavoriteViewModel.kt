package com.example.myapplication.viewmodel

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.FavoriteDao
import com.example.myapplication.database.FavoriteEntity
import com.example.myapplication.network.Recipes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val favoriteDao: FavoriteDao):ViewModel() {

   fun showFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAll()
   suspend fun deleteFavorite(favoriteEntity: FavoriteEntity){
      favoriteDao.delete(favoriteEntity)
   }

   fun recipeExists(id: Int): Boolean{
      return favoriteDao.recipeExists(id)
}
}