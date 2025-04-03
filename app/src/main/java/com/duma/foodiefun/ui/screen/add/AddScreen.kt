package com.duma.foodiefun.ui.screen.add

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.duma.foodiefun.R
import com.duma.foodiefun.data.database.entity.FoodEntity
import com.duma.foodiefun.di.Injection
import com.duma.foodiefun.ui.ViewModelFactory
import com.duma.foodiefun.ui.common.UiState
import com.duma.foodiefun.ui.theme.Shapes

@Composable
fun AddScreen(
    navController: NavController,
    viewModel: AddViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
) {
    val title by viewModel.title.collectAsState()
    val description by viewModel.description.collectAsState()
    val ingredients by viewModel.ingredients.collectAsState()
    val instructions by viewModel.instructions.collectAsState()
    val imageUri by viewModel.imageUri.collectAsState()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.updateImageUri(uri)
    }

    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is UiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = (uiState as UiState.Error).errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
        else -> {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            if (title.isNotEmpty() && description.isNotEmpty() && imageUri != null) {
                                val newFood = FoodEntity(
                                    id = System.currentTimeMillis(),
                                    image = imageUri.toString(),
                                    title = title,
                                    description = description,
                                    ingredients = ingredients.filter { it.isNotEmpty() },
                                    instructions = instructions.filter { it.isNotEmpty() },
                                    isFavorite = false
                                )
                                viewModel.addFood(newFood)
                                navController.popBackStack()
                            }
                        },
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ) {
                        Icon(Icons.Default.Check, contentDescription = stringResource(id = R.string.simpan))
                    }
                }
            ) { paddingValues ->
                AddForm(
                    title = title,
                    onTitleChange = viewModel::updateTitle,
                    description = description,
                    onDescriptionChange = viewModel::updateDescription,
                    imageUri = imageUri,
                    onImageUriChange = viewModel::updateImageUri,
                    onPickImage = { launcher.launch("image/*") },
                    ingredients = ingredients,
                    onIngredientsChange = viewModel::updateIngredients,
                    instructions = instructions,
                    onInstructionsChange = viewModel::updateInstructions,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}



@Composable
fun AddForm(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    imageUri: Uri?,
    onImageUriChange: (Uri?) -> Unit,
    onPickImage: () -> Unit,
    ingredients: List<String>,
    onIngredientsChange: (List<String>) -> Unit,
    instructions: List<String>,
    onInstructionsChange: (List<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        TextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text(stringResource(R.string.nama_menu)) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        TextField(
            value = description,
            onValueChange = onDescriptionChange,
            label = { Text(stringResource(R.string.deskripsi)) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
            )
        )

        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(it)
                        .crossfade(true)
                        .build()
                ),
                contentDescription = stringResource(id = R.string.gambar_terpilih),
                modifier = Modifier
                    .size(120.dp)
                    .clip(Shapes.medium)
            )
        }

        Button(onClick = onPickImage) {
            Text(stringResource(id = R.string.upload_gambar))
        }



        Text("Bahan-bahan:", fontWeight = FontWeight.Bold)
        ingredients.forEachIndexed { index, ingredient ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = ingredient,
                    onValueChange = { newValue ->
                        onIngredientsChange(ingredients.toMutableList().apply { set(index, newValue) })
                    },
                    label = { Text("Bahan ${index + 1}") },
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                IconButton(onClick = {
                    if (ingredients.size > 1) {
                        onIngredientsChange(ingredients.toMutableList().apply { removeAt(index) })
                    }
                }) {
                    Icon(Icons.Default.Delete, contentDescription = stringResource(id = R.string.hapus),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        Button(onClick = { onIngredientsChange(ingredients + "") }) {
            Text(stringResource(id = R.string.tambah_bahan))
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Instruksi:", fontWeight = FontWeight.Bold)
        instructions.forEachIndexed { index, instruction ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = instruction,
                    onValueChange = { newValue ->
                        onInstructionsChange(instructions.toMutableList().apply { set(index, newValue) })
                    },
                    label = { Text("Langkah ${index + 1}") },
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                IconButton(onClick = {
                    if (instructions.size > 1) {
                        onInstructionsChange(instructions.toMutableList().apply { removeAt(index) })
                    }
                }) {
                    Icon(Icons.Default.Delete, contentDescription = stringResource(id = R.string.hapus),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        Button(onClick = { onInstructionsChange(instructions + "") }) {
            Text(stringResource(id = R.string.tambah_langkah))
        }
    }
}




