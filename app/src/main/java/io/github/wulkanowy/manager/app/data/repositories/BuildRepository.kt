package io.github.wulkanowy.manager.app.data.repositories

import io.github.wulkanowy.manager.app.data.models.BuildArtifact
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildRepository @Inject constructor(private val client: HttpClient) {

    companion object {
        private const val BASE_URL = "https://wulkanowy-manager.herokuapp.com/v1"

        private const val UNSTABLE_BUILDS = "$BASE_URL/unstable"
    }

    suspend fun getUnstableBuilds(): List<BuildArtifact> = client.get(UNSTABLE_BUILDS)
}
