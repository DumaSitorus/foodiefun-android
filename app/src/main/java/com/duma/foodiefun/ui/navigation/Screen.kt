package com.duma.foodiefun.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Favorite: Screen("favorite")
    object Detail: Screen("home/{foodId}"){
        fun createRoute(foodId: Long) = "home/$foodId"
    }
    object Add: Screen("add")
    object Profile: Screen("Profile")
    object Info: Screen("info")
}