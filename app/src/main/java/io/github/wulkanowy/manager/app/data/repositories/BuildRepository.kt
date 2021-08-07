package io.github.wulkanowy.manager.app.data.repositories

import io.github.wulkanowy.manager.app.data.models.BuildArtifact
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildRepository @Inject constructor(private val client: HttpClient) {

    companion object {
        private const val BASE_URL = "https://bitrise-redirector.herokuapp.com"
        private const val APP_ID = "f841f20d8f8b1dc8"

        private const val LAST_ARTIFACTS = "$BASE_URL/v0.1/apps/$APP_ID/builds/master/artifacts"
    }

    suspend fun getLastArtifacts(): List<BuildArtifact> = client.get(LAST_ARTIFACTS)
}
