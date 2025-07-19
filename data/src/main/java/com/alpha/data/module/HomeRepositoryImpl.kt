package com.alpha.data.module

import com.alpha.domain.model.ApiRepository
import com.alpha.domain.model.RepoSearchResponse
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : ApiRepository {
    override suspend fun fetchGithubData(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse {
        return apiInterface.fetchGithubData(query, page, itemsPerPage)
    }
}