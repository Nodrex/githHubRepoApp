package com.flatrocktech.nodrex.api

import com.flatrocktech.nodrex.models.GithubRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("users/{user}/repos")
    suspend fun getRepoList(@Path("user") user: String): List<GithubRepo>

    @GET("repos/{owner}/{repo}")
    suspend fun getRepo(@Path("owner") owner: String, @Path("repo") repoName: String): GithubRepo

}