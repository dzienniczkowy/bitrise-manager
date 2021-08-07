package io.github.wulkanowy.manager.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class BuildArtifact(
    val title: String,
    val artifact_type: String,
    val artifact_meta: BuildArtifactMeta,
    val build_slug: String,
)

@Serializable
data class BuildArtifactMeta(
    val info_type_id: String,
    val file_size_bytes: String,
    val module: String,
    val product_flavour: String,
    val build_type: String,
)
