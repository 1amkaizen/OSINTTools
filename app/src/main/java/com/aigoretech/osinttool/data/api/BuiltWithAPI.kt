package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface BuiltWithApi {
    @GET("api/v2")
    fun getTechnologyData(@Query("url") url: String, @Query("token") token: String): Call<BuiltWithResponse>

    companion object {
        private const val BASE_URL = "https://api.builtwith.com/v17/"
        
        fun create(): BuiltWithApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(BuiltWithApi::class.java)
        }
    }
}
