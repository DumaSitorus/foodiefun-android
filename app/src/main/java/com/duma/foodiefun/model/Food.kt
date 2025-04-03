package com.duma.foodiefun.model

data class Food(
    val id: Long,
    val image: String,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val isFavorite: Boolean
)
