package com.duma.foodiefun.data

import com.duma.foodiefun.data.database.entity.FoodEntity
import com.duma.foodiefun.data.database.room.FoodDao
import kotlinx.coroutines.flow.Flow

class FoodRepository(private val foodDao: FoodDao) {

    fun getAllFood(): Flow<List<FoodEntity>> {
        return foodDao.getAllFood()
    }

    fun searchFood(query: String): Flow<List<FoodEntity>> {
        return foodDao.searchFood("%$query%")
    }
    fun searchFavFood(query: String): Flow<List<FoodEntity>> {
        return foodDao.searchFavFood("%$query%")
    }

    fun getFavoriteFood(): Flow<List<FoodEntity>> {
        return foodDao.getFavoriteFood()
    }

    fun getFoodById(foodId: Long): Flow<FoodEntity?> {
        return foodDao.getFoodById(foodId)
    }

    suspend fun updateFood(food: FoodEntity) {
        foodDao.update(food)
    }

    suspend fun insertFood(food: FoodEntity) {
        foodDao.insertFood(food)
    }

    suspend fun deleteFood(food: FoodEntity){
        foodDao.delete(food)
    }

    companion object {
        @Volatile
        private var instance: FoodRepository? = null

        fun getInstance(foodDao: FoodDao): FoodRepository =
            instance ?: synchronized(this) {
                FoodRepository(foodDao).also { instance = it }
            }
    }
}

