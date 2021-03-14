package io.github.wulkanowymanager.ui.modules

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.wulkanowymanager.data.models.BuildArtifact
import io.github.wulkanowymanager.data.repositories.BuildRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val buildRepository: BuildRepository) :
    ViewModel() {

    val artifacts = mutableStateOf<List<BuildArtifact>>(emptyList())

    fun loadData() {
        viewModelScope.launch {
            artifacts.value = buildRepository.getLastArtifacts()
        }
    }
}
