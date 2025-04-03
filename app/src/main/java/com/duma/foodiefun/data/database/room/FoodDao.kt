package com.duma.foodiefun.data.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.duma.foodiefun.data.database.entity.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM foods")
    fun getAllFood(): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods WHERE title LIKE :query")
    fun searchFood(query: String): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods WHERE title LIKE :query AND isFavorite = 1")
    fun searchFavFood(query: String): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods WHERE id = :foodId")
    fun getFoodById(foodId: Long): Flow<FoodEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: FoodEntity)

    @Query("SELECT * FROM foods WHERE isFavorite = 1")
    fun getFavoriteFood(): Flow<List<FoodEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(foods: List<FoodEntity>)

    @Update
    suspend fun update(food: FoodEntity)

    @Delete
    suspend fun delete(food: FoodEntity)
}