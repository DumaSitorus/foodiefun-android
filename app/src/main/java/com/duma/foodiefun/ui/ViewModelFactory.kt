package com.duma.foodiefun.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.duma.foodiefun.data.FoodRepository
import com.duma.foodiefun.ui.screen.add.AddViewModel
import com.duma.foodiefun.ui.screen.detail.DetailViewModel
import com.duma.foodiefun.ui.screen.favorite.FavoriteViewModel
import com.duma.foodiefun.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: FoodRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                DetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                FavoriteViewModel(repository) as T
            }
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                AddViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

