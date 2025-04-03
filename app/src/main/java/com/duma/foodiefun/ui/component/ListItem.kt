package com.duma.foodiefun.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.duma.foodiefun.R
import com.duma.foodiefun.ui.theme.FoodieFunTheme
import com.duma.foodiefun.ui.theme.Shapes

@SuppressLint("DiscouragedApi")
@Composable
fun ListItem(
    foodId: Long,
    imageName: String,
    title: String,
    description: String,
    onDelete: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    val imagePainter = if (imageName.startsWith("content://")) {
        rememberAsyncImagePainter(imageName)
    } else {
        val imageResId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
        painterResource(id = imageResId.takeIf { it != 0 } ?: R.drawable.loading)
    }

    Row (
        modifier = modifier
            .fillMaxWidth()
            .clip(Shapes.medium)
            .background(MaterialTheme.colorScheme.tertiary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = imagePainter,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .padding(4.dp)
                .clip(Shapes.medium)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(2.0f)
        ) {
            Text(
                text = title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall.copy()
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp).weight(0.5f)
                    .clickable { showDialog = true }
            )
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { stringResource(R.string.konfirmasi_hapus) },
                text = { Text("Apakah kamu yakin ingin menghapus \"$title\"?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onDelete(foodId)
                            showDialog = false
                        }
                    ) {
                        Text(stringResource(id = R.string.hapus), color = Color.Red)
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(stringResource(id = R.string.batal))
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemPreview() {
    FoodieFunTheme {
        ListItem(1, "food_1", "Nasi Goreng", "Simple lejat bergiji", onDelete = {})
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun ListGridItem(
    foodId: Long,
    imageName: String,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    val imagePainter = if (imageName.startsWith("content://")) {
        rememberAsyncImagePainter(imageName)
    } else {
        val imageResId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
        painterResource(id = imageResId.takeIf { it != 0 } ?: R.drawable.loading)
    }

    Column (
        modifier = modifier
            .clip(Shapes.medium)
            .background(MaterialTheme.colorScheme.tertiary),
    ) {
        Image(
            painter = imagePainter,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(4.dp)
                .size(150.dp)
                .clip(Shapes.small)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall.copy()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemGridPreview() {
    FoodieFunTheme {
        ListGridItem(1, "food_1", "Nasi Goreng", "Simple lejat bergiji")
    }
}