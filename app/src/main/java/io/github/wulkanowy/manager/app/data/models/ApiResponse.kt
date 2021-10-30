package io.github.wulkanowy.manager.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val error: String? = null,
    val data: T? = null,
)
