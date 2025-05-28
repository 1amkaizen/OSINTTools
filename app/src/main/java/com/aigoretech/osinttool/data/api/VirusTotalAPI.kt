package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Header
import retrofit2.Call

interface VirusTotalApi {
    @GET("virus-total/{id}")
    fun getFileReport(@Path("id") id: String, @Header("x-apikey") apiKey: String): Call<VirusTotalReport>

    companion object {
        private const val BASE_URL = "https://www.virustotal.com/api/v3/files/"

        fun create(): VirusTotalApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(VirusTotalApi::class.java)
        }
    }
}
