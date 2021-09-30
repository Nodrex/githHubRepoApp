package com.flatrocktech.nodrex.models

import com.google.gson.annotations.SerializedName

data class GithubRepo(
    @SerializedName("created_at")
    val creationDate: String,
    val description: Any,
    @SerializedName("html_url")
    val url: String,
    val id: Int,
    val language: String,
    val name: String,
    val owner: Owner
)