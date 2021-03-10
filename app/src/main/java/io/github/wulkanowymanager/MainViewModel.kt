package io.github.wulkanowymanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.wulkanowymanager.data.repositories.BuildRepository
import kotlinx.coroutines.launch

class MainViewModel(private val buildRepository: BuildRepository) : ViewModel() {

    fun loadData() {
        viewModelScope.launch {
            val artifacts = buildRepository.getLastArtifacts()
            println(artifacts)
        }
    }
}
