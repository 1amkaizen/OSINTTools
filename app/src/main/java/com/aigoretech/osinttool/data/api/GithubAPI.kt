package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface GitHubApi {
    @GET("users/{username}")
    fun getUserProfile(@Path("username") username: String): Call<ProfileData>

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GitHubApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GitHubApi::class.java)
        }
    }
}
