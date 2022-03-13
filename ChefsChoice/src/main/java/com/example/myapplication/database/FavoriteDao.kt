package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.network.Recipes
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM `favoriteList`")
    fun getAll(): Flow<List<FavoriteEntity>>


   /* @Query("SELECT EXISTS (SELECT 1 FROM favoriteList WHERE id=:id)")
    fun isFavorite(id: Int): Int

    @Delete
    suspend fun delete(favoriteEntity: FavoriteEntity?)*/
}