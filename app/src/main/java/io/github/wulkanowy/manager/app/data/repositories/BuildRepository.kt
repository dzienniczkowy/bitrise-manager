package io.github.wulkanowy.manager.app.data.repositories

import io.github.wulkanowy.manager.app.data.models.ApiResponse
import io.github.wulkanowy.manager.app.data.models.PullRequestBuild
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildRepository @Inject constructor(private val client: HttpClient) {

    companion object {
        private const val APP_ID = "daeff1893f3c8128"
        private const val REPO_NAME = "wulkanowy"
        private const val UNSTABLE_BUILDS = "/v1/pr/app/$APP_ID/repo/$REPO_NAME"
    }

    suspend fun getUnstableBuilds(): List<PullRequestBuild> =
        client.get<ApiResponse<List<PullRequestBuild>>>(UNSTABLE_BUILDS).data!!
}
