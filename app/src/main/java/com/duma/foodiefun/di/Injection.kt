package com.duma.foodiefun.di

import android.content.Context
import com.duma.foodiefun.data.FoodRepository
import com.duma.foodiefun.data.database.room.FoodDatabase

object Injection {
    fun provideRepository(context: Context): FoodRepository {
        val database = FoodDatabase.getInstance(context)
        return FoodRepository.getInstance(database.foodDao())
    }
}