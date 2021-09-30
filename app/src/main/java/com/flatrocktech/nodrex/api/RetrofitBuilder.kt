package com.flatrocktech.nodrex.api

import com.flatrocktech.nodrex.config.AppConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val api: Api by lazy {
        retrofitBuilder
            .build()
            .create(Api::class.java)
    }

}