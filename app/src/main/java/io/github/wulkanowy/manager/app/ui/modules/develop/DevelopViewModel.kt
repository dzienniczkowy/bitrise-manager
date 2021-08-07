package io.github.wulkanowy.manager.app.ui.modules.develop

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.wulkanowy.manager.app.data.models.BuildArtifact
import io.github.wulkanowy.manager.app.data.repositories.BuildRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevelopViewModel @Inject constructor(
    private val buildRepository: BuildRepository,
) : ViewModel() {

    val artifacts = mutableStateOf<List<BuildArtifact>>(emptyList())

    init {
        viewModelScope.launch {
            artifacts.value = buildRepository.getLastArtifacts()
        }
    }
}
