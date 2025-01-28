package com.example.android.cactus.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_URL = "https://translate.api.cloud.yandex.net/translate/"
    private const val API_KEY = "AQVN3HpbXXvHWCNMRdYpRTtsMPZbOTEjgwZhfRKV"

    private val client by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Api-Key $API_KEY")
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: TranslateApiService by lazy {
        retrofit.create(TranslateApiService::class.java)
    }
}
