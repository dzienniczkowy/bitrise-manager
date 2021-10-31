package io.github.wulkanowy.manager.app.ui.modules.develop

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.wulkanowy.manager.app.data.models.PullRequestBuild
import io.github.wulkanowy.manager.app.data.repositories.BuildRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DevelopViewModel @Inject constructor(
    private val buildRepository: BuildRepository,
) : ViewModel() {

    val artifacts = mutableStateOf<List<PullRequestBuild>>(emptyList())

    val isLoading = mutableStateOf(false)

    val error = mutableStateOf<Throwable?>(null)

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            try {
                isLoading.value = true
                artifacts.value = buildRepository.getUnstableBuilds()
            } catch (e: Throwable) {
                error.value = e
                Timber.e(e)
            } finally {
                isLoading.value = false
            }
        }
    }
}
