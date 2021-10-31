package io.github.wulkanowy.manager.app.ui.modules.develop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GetApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import io.github.wulkanowy.manager.app.data.models.BitriseBuildInfo
import io.github.wulkanowy.manager.app.data.models.PullRequestBuild
import io.github.wulkanowy.manager.app.data.models.PullRequestInfo
import io.github.wulkanowy.manager.app.ui.theme.PersianRed

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
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = PersianRed, fontWeight = FontWeight(400))) {
                        append(item.pullRequest.title)
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0x99000000),
                            fontWeight = FontWeight(300)
                        )
                    ) {
                        append("#${item.pullRequest.number}")
                    }
                }, fontSize = 20.sp, lineHeight = 24.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    if (item.build != null) {
                        Text(text = item.build.buildNumber.toString(), color = Color(0x99000000))
                        Spacer(Modifier.width(4.dp))
                        Text(text = item.build.buildTimestamp, color = Color(0x66000000))
                        Spacer(Modifier.width(8.dp))
                    }
                    Image(
                        painter = rememberImagePainter(item.pullRequest.userAvatarUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(text = item.pullRequest.userLogin, color = Color(0x99000000))
                }
            }
            Icon(
                imageVector = Icons.Rounded.GetApp,
                contentDescription = "Download",
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.CenterVertically)
            )
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
