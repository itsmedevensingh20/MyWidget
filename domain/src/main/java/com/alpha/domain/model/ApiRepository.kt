package com.alpha.domain.model

interface ApiRepository {
    suspend fun fetchGithubData(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse
}
