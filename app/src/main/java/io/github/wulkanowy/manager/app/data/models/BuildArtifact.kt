package io.github.wulkanowy.manager.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class BuildArtifact(
    val id: Long,
    val title: String,
    val number: Int,
    val buildTimestamp: String,
    val githubUrl: String,
    val downloadUrl: String,
    val buildUrl: String,
    val buildNumber: Int,
    val userAvatarUrl: String,
    val userLogin: String,
    val commitSha: String,
)
