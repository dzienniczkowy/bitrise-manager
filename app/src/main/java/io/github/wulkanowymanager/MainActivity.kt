package io.github.wulkanowymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.wulkanowymanager.data.models.BuildArtifact
import io.github.wulkanowymanager.ui.theme.WulkanowymanagerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

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
