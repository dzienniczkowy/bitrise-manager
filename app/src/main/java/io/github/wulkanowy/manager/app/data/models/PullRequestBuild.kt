package io.github.wulkanowy.manager.app.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PullRequestBuild(
    @SerialName("pull_reqest")
    val pullRequest: PullRequestInfo,
    @SerialName("build")
    val build: BitriseBuildInfo?,
)

@Serializable
data class PullRequestInfo(
    val id: Long,
    val title: String,
    val number: Int,
    @SerialName("github_url")
    val githubUrl: String,
    @SerialName("user_avatar_url")
    val userAvatarUrl: String,
    @SerialName("user_login")
    val userLogin: String,
    @SerialName("commit_sha")
    val commitSha: String,
)

@Serializable
data class BitriseBuildInfo(
    @SerialName("build_timestamp")
    val buildTimestamp: String,
    @SerialName("build_slug")
    val buildSlug: String,
    @SerialName("artifact_slug")
    val artifactSlug: String,
    @SerialName("build_number")
    val buildNumber: Int,
)
