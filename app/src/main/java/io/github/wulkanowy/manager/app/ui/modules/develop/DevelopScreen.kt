package io.github.wulkanowy.manager.app.ui.modules.develop

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun DevelopScreen(
    navController: NavHostController,
    viewModel: DevelopViewModel = viewModel()
) {
    val artifacts by remember { viewModel.artifacts }

    LazyColumn {
        items(artifacts) { item ->
            Text(text = item.toString())
        }
    }
}
