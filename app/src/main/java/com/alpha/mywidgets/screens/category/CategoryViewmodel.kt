package com.alpha.mywidgets.screens.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alpha.domain.model.ApiRepository
import com.alpha.domain.model.RepoSearchResponse
import com.alpha.mywidgets.ApiResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewmodel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _repository1: MutableStateFlow<ApiResultState<RepoSearchResponse>> =
        MutableStateFlow(ApiResultState.Loading(null))
    var repository: StateFlow<ApiResultState<RepoSearchResponse>> = _repository1.asStateFlow()

    fun fetchGitRepository() = viewModelScope.launch {
        _repository1.value = ApiResultState.Loading(true)
        try {
            val res = apiRepository.fetchGithubData(
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