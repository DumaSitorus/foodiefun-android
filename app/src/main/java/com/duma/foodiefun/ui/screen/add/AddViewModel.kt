package com.duma.foodiefun.ui.screen.add

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duma.foodiefun.data.FoodRepository
import com.duma.foodiefun.data.database.entity.FoodEntity
import com.duma.foodiefun.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<Unit>>(UiState.Success(Unit))
    val uiState: StateFlow<UiState<Unit>> = _uiState

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _description = MutableStateFlow("")
    val description: StateFlow<String> = _description

    private val _ingredients = MutableStateFlow(listOf(""))
    val ingredients: StateFlow<List<String>> = _ingredients

    private val _instructions = MutableStateFlow(listOf(""))
    val instructions: StateFlow<List<String>> = _instructions

    private val _imageUri = MutableStateFlow<Uri?>(null)
    val imageUri: StateFlow<Uri?> = _imageUri

    fun updateTitle(newTitle: String) {
        _title.value = newTitle
    }

    fun updateDescription(newDescription: String) {
        _description.value = newDescription
    }

    fun updateIngredients(newIngredients: List<String>) {
        _ingredients.value = newIngredients
    }

    fun updateInstructions(newInstructions: List<String>) {
        _instructions.value = newInstructions
    }

    fun updateImageUri(newUri: Uri?) {
        _imageUri.value = newUri
    }

    fun addFood(food: FoodEntity) {
        if (_title.value.isNotEmpty() && _description.value.isNotEmpty() && _imageUri.value != null) {
            val newFood = FoodEntity(
                id = System.currentTimeMillis(),
                image = _imageUri.value.toString(),
                title = _title.value,
                description = _description.value,
                ingredients = _ingredients.value.filter { it.isNotEmpty() },
                instructions = _instructions.value.filter { it.isNotEmpty() },
                isFavorite = false
            )

            viewModelScope.launch {
                _uiState.value = UiState.Loading
                try {
                    repository.insertFood(newFood)
                    _uiState.value = UiState.Success(Unit)
                } catch (e: Exception) {
                    _uiState.value = UiState.Error(e.message ?: "Terjadi kesalahan")
                }
            }
        }
    }
}
