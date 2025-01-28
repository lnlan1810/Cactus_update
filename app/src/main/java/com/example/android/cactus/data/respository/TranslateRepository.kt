package com.example.android.cactus.data.respository

import com.example.android.cactus.data.network.ApiClient
import com.example.android.cactus.domain.model.TranslateRequest


class TranslateRepository {
    private val apiService = ApiClient.apiService

    suspend fun translateWord(request: TranslateRequest) = apiService.translate(request)
}
