package com.example.myapplication.database

import android.content.ClipData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favoriteList ORDER BY id ASC")
    fun getAll(): Flow<List<FavoriteEntity>>

   /* @Query("SELECT * from item WHERE id = :id")
    fun getFavorite(id: Int): Flow<FavoriteEntity> */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteEntity: FavoriteEntity)

    @Delete
    suspend fun delete(favoriteEntity: FavoriteEntity)

}