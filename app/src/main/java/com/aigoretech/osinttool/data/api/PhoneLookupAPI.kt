package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface PhoneLookupAPI {
    @GET("lookup")
    fun lookupPhoneNumber(@Query("number") number: String, @Query("apikey") apiKey: String): Call<PhoneLookupResult>

    companion object {
        private const val BASE_URL = "https://api.phonelookup.com/"

        fun create(): PhoneLookupAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(PhoneLookupAPI::class.java)
        }
    }
}
