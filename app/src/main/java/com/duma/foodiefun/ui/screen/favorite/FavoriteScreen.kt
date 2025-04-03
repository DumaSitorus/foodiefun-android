package com.duma.foodiefun.ui.screen.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.duma.foodiefun.ui.component.ListGridItem
import com.duma.foodiefun.ui.component.SearchBar

@Composable
fun FavoriteContent(
    foodList: List<Food>,
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    Column(modifier = modifier) {
        SearchBar(
            query = query,
            onQueryChange = onQueryChange,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(foodList.size) { index ->
                val food = foodList[index]
                ListGridItem(
                    foodId = food.id,
                    imageName = food.image,
                    title = food.title,
                    description = food.description,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            navigateToDetail(food.id)
                        },
                )
            }
        }
    }
}

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToDetail: (Long) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    val query = viewModel.query.value

    when (uiState) {
        is UiState.Loading -> {
            viewModel.getAllFavFood()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success<*> -> {
            val foodList = (uiState as UiState.Success<List<Food>>).data
            FavoriteContent(
                foodList = foodList,
                query = query,
                onQueryChange = { newQuery -> viewModel.search(newQuery) },
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