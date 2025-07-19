package com.alpha.mywidgets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpha.domain.model.ApiRepository
import com.alpha.domain.model.RepoSearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val homeRepository: ApiRepository,
) : ViewModel() {

    init {
        fetchGitRepository()
    }

    private val _repository1: MutableStateFlow<ApiResultState<RepoSearchResponse>> =
        MutableStateFlow(ApiResultState.Loading(null))
    var repository: StateFlow<ApiResultState<RepoSearchResponse>> = _repository1.asStateFlow()

    private fun fetchGitRepository() = viewModelScope.launch {
        _repository1.value = ApiResultState.Loading(true)
        try {
            val res = homeRepository.fetchGithubData(
                query = "language:Kotlin",
                page = 1,
                itemsPerPage = 10
            )
            _repository1.value = ApiResultState.Success(res)

        } catch (e: Exception) {
            _repository1.value = ApiResultState.Error(e.message.toString())
        }

    }

}