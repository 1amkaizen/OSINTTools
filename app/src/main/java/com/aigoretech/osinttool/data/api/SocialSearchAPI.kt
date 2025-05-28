package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface SocialSearchApi {
    @GET("search")
    fun searchProfile(@Query("username") username: String): Call<SocialProfileResult>

    companion object {
        private const val BASE_URL = "https://api.social-searcher.com/v1/"

        fun create(): SocialSearchApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(SocialSearchApi::class.java)
        }
    }
}
