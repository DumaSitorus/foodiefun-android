package com.duma.foodiefun.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duma.foodiefun.data.FoodRepository
import com.duma.foodiefun.data.database.entity.toFood
import com.duma.foodiefun.model.Food
import com.duma.foodiefun.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Food>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Food>>> = _uiState

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    init {
        getAllFood()
    }

    fun search(newQuery: String) {
        _query.value = newQuery
        viewModelScope.launch {
            repository.searchFood(newQuery)
                .catch { exception ->
                    _uiState.value = UiState.Error(exception.message ?: "Terjadi kesalahan")
                }
                .collect { foodEntities ->
                    val searchResults = foodEntities.map { it.toFood() }
                    _uiState.value = UiState.Success(searchResults)
                }
        }
    }

    fun getAllFood() {
        viewModelScope.launch {
            repository.getAllFood()
                .catch { exception ->
                    _uiState.value = UiState.Error(exception.message ?: "Terjadi kesalahan")
                }
                .collect { foodEntities ->
                    val foodList = foodEntities.map { it.toFood() }
                    _uiState.value = UiState.Success(foodList)
                }
        }
    }

    fun deleteFoodById(foodId: Long) {
        viewModelScope.launch {
            repository.getFoodById(foodId).collect { foodEntity ->
                foodEntity?.let {
                    repository.deleteFood(it)
                    getAllFood()
                }
            }
        }
    }

}
