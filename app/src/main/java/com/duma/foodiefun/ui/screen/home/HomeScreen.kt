package com.duma.foodiefun.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.duma.foodiefun.R
import com.duma.foodiefun.di.Injection
import com.duma.foodiefun.model.Food
import com.duma.foodiefun.ui.ViewModelFactory
import com.duma.foodiefun.ui.common.UiState
import com.duma.foodiefun.ui.component.ListItem
import com.duma.foodiefun.ui.component.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    foodList: List<Food>,
    query: String,
    onQueryChange: (String) -> Unit,
    onDeleteFood: (Long) -> Unit,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(top = 0.dp),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        stickyHeader {
            SearchBar(
                query = query,
                onQueryChange = onQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
            items(foodList) { food ->
                ListItem(
                    foodId = food.id,
                    imageName = food.image,
                    title = food.title,
                    description = food.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navigateToDetail(food.id)
                        },
                        onDelete = onDeleteFood
                )
            }
        }
    }

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToDetail: (Long) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    val query = viewModel.query.value

    when (uiState) {
        is UiState.Loading -> {
            viewModel.getAllFood()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success<*> -> {
            val foodList = (uiState as UiState.Success<List<Food>>).data
            HomeContent(
                foodList = foodList,
                query = query,
                onQueryChange = { newQuery -> viewModel.search(newQuery) },
                onDeleteFood = { foodId -> viewModel.deleteFoodById(foodId) },
                modifier = modifier,
                navigateToDetail = navigateToDetail,
            )
        }
        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(stringResource(id = R.string.gagal_memuat_data), color = Color.Red)
            }
        }
    }
}