package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import com.example.myapplication.RecipesViewModel
import com.example.myapplication.database.FavoriteDao

class RecipesViewModelFactory (private val favoriteDao: FavoriteDao) : ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RecipesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RecipesViewModel(favoriteDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}