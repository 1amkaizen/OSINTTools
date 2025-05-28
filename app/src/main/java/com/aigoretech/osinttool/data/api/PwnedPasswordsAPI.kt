package com.example.osinttool.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface PwnedPasswordsApi {
    @GET("range/{prefix}")
    fun checkPassword(@Path("prefix") prefix: String): Call<List<PwnedPasswordResult>>

    companion object {
        private const val BASE_URL = "https://api.pwnedpasswords.com/range/"

        fun create(): PwnedPasswordsApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(PwnedPasswordsApi::class.java)
        }
    }
}
