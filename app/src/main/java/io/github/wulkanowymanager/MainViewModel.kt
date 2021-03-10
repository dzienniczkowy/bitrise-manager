package io.github.wulkanowymanager

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.wulkanowymanager.data.models.BuildArtifact
import io.github.wulkanowymanager.data.repositories.BuildRepository
import kotlinx.coroutines.launch

class MainViewModel(private val buildRepository: BuildRepository) : ViewModel() {

    val artifacts = mutableStateOf<List<BuildArtifact>>(emptyList())

    fun loadData() {
        viewModelScope.launch {
            artifacts.value = buildRepository.getLastArtifacts()
        }
    }
}
