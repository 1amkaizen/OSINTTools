package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface CensysApi {
    @GET("search/ipv4")
    fun searchIPv4(@Query("query") query: String, @Query("fields") fields: String, @Query("page") page: Int): Call<CensysResponse>

    companion object {
        private const val BASE_URL = "https://censys.io/api/v1/"

        fun create(): CensysApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CensysApi::class.java)
        }
    }
}
