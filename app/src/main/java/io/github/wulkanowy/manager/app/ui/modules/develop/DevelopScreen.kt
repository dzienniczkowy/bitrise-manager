package io.github.wulkanowy.manager.app.ui.modules.develop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import io.github.wulkanowy.manager.app.data.models.BitriseBuildInfo
import io.github.wulkanowy.manager.app.data.models.PullRequestBuild
import io.github.wulkanowy.manager.app.data.models.PullRequestInfo

@Composable
fun DevelopScreen(
    navController: NavHostController,
    viewModel: DevelopViewModel = viewModel()
) {
    val artifacts by remember { viewModel.artifacts }

    LazyColumn {
        items(artifacts) {
            BuildCard(item = it)
        }
    }
}

@Composable
fun BuildCard(item: PullRequestBuild) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column {
                Text(text = item.pullRequest.title)
                Row {
                    Text(text = item.build?.buildNumber.toString(), modifier = Modifier.padding(end = 5.dp))
                    Text(text = item.build?.buildTimestamp.toString())
                }
            }
        }
    }
}

@Preview
@Composable
fun BuildCardPreview() {
    BuildCard(
        item = PullRequestBuild(
            pullRequest = PullRequestInfo(
                id = 755547692,
                title = "Error messages content wrap in error dialog",
                number = 1577,
                githubUrl = "https://github.com/wulkanowy/wulkanowy/pull/1577",
                userAvatarUrl = "https://avatars.githubusercontent.com/u/60961958?v=4",
                userLogin = "Daxxxis",
                commitSha = "19af80c80f46538bf1a9de0e40667e5a27e2c044"
            ),
            build = BitriseBuildInfo(
                buildNumber = 5970,
                buildSlug = "0c8dd6a6-a9ba-4f57-a50a-293af9a005d4",
                artifactSlug = "1d4577d0e39302d4",
                buildTimestamp = "2021-10-29T19:25:08Z"
            ),
        )
    )
}
