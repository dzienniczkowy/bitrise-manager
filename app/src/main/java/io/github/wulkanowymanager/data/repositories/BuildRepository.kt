package io.github.wulkanowymanager.data.repositories

import io.github.wulkanowymanager.data.models.BuildArtifact
import io.ktor.client.*
import io.ktor.client.request.*

class BuildRepository(private val client: HttpClient) {

    companion object {
        private const val BASE_URL = "https://bitrise-redirector.herokuapp.com"
        private const val APP_ID = "f841f20d8f8b1dc8"

        private const val LAST_ARTIFACTS = "$BASE_URL/v0.1/apps/$APP_ID/builds/master/artifacts"
    }

    suspend fun getLastArtifacts(): List<BuildArtifact> = client.get(LAST_ARTIFACTS)
}
