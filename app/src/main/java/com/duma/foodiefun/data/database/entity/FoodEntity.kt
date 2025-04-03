package com.duma.foodiefun.data.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.duma.foodiefun.model.Food
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "foods")
data class FoodEntity(
    @PrimaryKey val id: Long,
    val image: String,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val isFavorite: Boolean = false
) : Parcelable

fun FoodEntity.toFood(): Food {
    return Food(
        id = this.id,
        image = this.image,
        title = this.title,
        description = this.description,
        ingredients = this.ingredients,
        instructions = this.instructions,
        isFavorite = this.isFavorite
    )
}

fun Food.toEntity(): FoodEntity {
    return FoodEntity(
        id = this.id,
        image = this.image,
        title = this.title,
        description = this.description,
        ingredients = this.ingredients,
        instructions = this.instructions,
        isFavorite = this.isFavorite
    )
}
