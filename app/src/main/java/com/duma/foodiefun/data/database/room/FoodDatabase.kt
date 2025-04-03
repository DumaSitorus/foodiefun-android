package com.duma.foodiefun.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.duma.foodiefun.data.database.Converters
import com.duma.foodiefun.data.database.entity.FoodEntity
import com.duma.foodiefun.model.FakeFoodDataSource

@Database(entities = [FoodEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class FoodDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getInstance(context: Context): FoodDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "food_database"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Thread {
                                getInstance(context).foodDao().insertAll(
                                    FakeFoodDataSource.dummyFood.map { food ->
                                        FoodEntity(
                                            id = food.id,
                                            image = food.image,
                                            title = food.title,
                                            description = food.description,
                                            ingredients = food.ingredients,
                                            instructions = food.instructions,
                                            isFavorite = false
                                        )
                                    }
                                )
                            }.start()
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}