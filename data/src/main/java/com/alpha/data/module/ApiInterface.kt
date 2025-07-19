package com.alpha.data.module

import com.alpha.domain.model.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("search/repositories?sort=stars")
    suspend fun fetchGithubData(
        @Query("q") query: String? = null,
        @Query("page") page: Int? = null,
        @Query("per_page") itemsPerPage: Int? = null
    ): RepoSearchResponse

}