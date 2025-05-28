package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface ShodanApi {
    @GET("shodan/host/search")
    fun searchHost(@Query("key") apiKey: String, @Query("query") search: String): Call<ShodanResponse>

    companion object {
        private const val BASE_URL = "https://api.shodan.io/"

        fun create(): ShodanApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ShodanApi::class.java)
        }
    }
}
