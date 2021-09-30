package com.flatrocktech.nodrex.repository

import com.flatrocktech.nodrex.api.RetrofitBuilder
import com.flatrocktech.nodrex.models.GithubRepo

object Repository {

    suspend fun getRepoList(user: String): List<GithubRepo> {
        return try {
            RetrofitBuilder.api.getRepoList(user)
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getRepo(owner: String, repoName: String): GithubRepo? {
        return try {
            RetrofitBuilder.api.getRepo(owner, repoName)
        } catch (e: Exception) {
            null
        }
    }

}