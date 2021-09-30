package com.flatrocktech.nodrex.models

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("login")
    val userName: String
)