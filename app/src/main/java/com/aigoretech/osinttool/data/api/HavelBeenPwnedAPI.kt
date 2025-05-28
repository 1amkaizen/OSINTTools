package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface HaveIBeenPwnedApi {
    @GET("api/v2/breachedaccount/{email}")
    fun checkBreach(@Path("email") email: String): Call<List<BreachData>>

    companion object {
        private const val BASE_URL = "https://haveibeenpwned.com/"

        fun create(): HaveIBeenPwnedApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(HaveIBeenPwnedApi::class.java)
        }
    }
}
