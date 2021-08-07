package io.github.wulkanowy.manager.app.ui.modules

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import io.github.wulkanowy.manager.app.data.models.BuildArtifact
import io.github.wulkanowy.manager.app.ui.theme.WulkanowymanagerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.loadData()

        setContent {
            WulkanowymanagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(mainViewModel.artifacts.value)
                }
            }
        }
    }
}

@Composable
fun Greeting(items: List<BuildArtifact>) {
    Text(text = "Hello $items!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WulkanowymanagerTheme {
        Greeting(emptyList())
    }
}
