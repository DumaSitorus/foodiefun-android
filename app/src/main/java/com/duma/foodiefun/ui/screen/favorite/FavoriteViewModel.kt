package com.duma.foodiefun.ui.screen.favorite

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

class FavoriteViewModel (
    private val repository: FoodRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Food>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Food>>> = _uiState

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    init {
        getAllFavFood()
    }

    fun search(newQuery: String) {
        _query.value = newQuery
        viewModelScope.launch {
            repository.searchFavFood(newQuery)
                .catch { exception ->
                    _uiState.value = UiState.Error(exception.message ?: "Terjadi kesalahan")
                }
                .collect { foodEntities ->
                    val searchResults = foodEntities.map { it.toFood() }
                    _uiState.value = UiState.Success(searchResults)
                }
        }
    }

    fun getAllFavFood() {
        viewModelScope.launch {
            repository.getFavoriteFood()
                .catch { exception ->
                    _uiState.value = UiState.Error(exception.message ?: "Terjadi kesalahan")
                }
                .collect { foodEntities ->
                    val foodList = foodEntities.map { it.toFood() }
                    _uiState.value = UiState.Success(foodList)
                }
        }
    }
}