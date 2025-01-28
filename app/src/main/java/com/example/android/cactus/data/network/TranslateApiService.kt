package com.example.android.cactus.data.network

import com.example.android.cactus.domain.model.TranslateRequest
import com.example.android.cactus.domain.model.TranslateResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TranslateApiService {
    @Headers("Content-Type: application/json")
    @POST("v2/translate")
    suspend fun translate(@Body request: TranslateRequest): TranslateResponse
}