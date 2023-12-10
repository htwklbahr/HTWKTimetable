package com.lb.functionalities.data.api

import com.lb.functionalities.data.api.dummydata.DummyLectures
import com.lb.functionalities.data.api.model.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class LecturesApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getPlaceholderData(): List<PlaceholderObject> {
        return httpClient.get("https://jsonplaceholder.typicode.com/albums").body()
    }

    fun getDummyLectureData(): List<LectureObject> {
        return DummyLectures.lectures
    }
}

