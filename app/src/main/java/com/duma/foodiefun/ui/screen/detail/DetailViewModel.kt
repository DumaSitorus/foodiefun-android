package com.duma.foodiefun.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duma.foodiefun.data.FoodRepository
import com.duma.foodiefun.data.database.entity.toEntity
import com.duma.foodiefun.data.database.entity.toFood
import com.duma.foodiefun.model.Food
import com.duma.foodiefun.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: FoodRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<Food>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Food>> = _uiState

    fun getFoodDetail(foodId: Long) {
        viewModelScope.launch {
            repository.getFoodById(foodId)
                .catch { exception ->
                    _uiState.value = UiState.Error(exception.message ?: "Terjadi kesalahan")
                }
                .collectLatest { foodEntity ->
                    if (foodEntity != null) {
                        _uiState.value = UiState.Success(foodEntity.toFood())
                    } else {
                        _uiState.value = UiState.Error("Data tidak ditemukan")
                    }
                }
        }
    }

    fun toggleFavorite() {
        val currentState = _uiState.value
        if (currentState is UiState.Success) {
            val food = currentState.data
            val updatedFood = food.copy(isFavorite = !food.isFavorite)

            viewModelScope.launch {
                repository.updateFood(updatedFood.toEntity())
                _uiState.value = UiState.Success(updatedFood)
            }
        }
    }
}

