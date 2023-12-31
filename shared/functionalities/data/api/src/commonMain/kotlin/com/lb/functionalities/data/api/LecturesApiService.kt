package com.lb.functionalities.data.api

import com.lb.functionalities.data.api.dummydata.DummyLectures
import com.lb.functionalities.data.api.model.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal class LecturesApiService {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    /**
     * Function for getting data from an API. Can be adjusted for own use.
     */
    suspend fun getPlaceholderData(): List<PlaceholderObject> {
        return httpClient.get("https://jsonplaceholder.typicode.com/albums").body()
    }

    /**
     * Gets dummy data since there is no actual API for the lecture data.
     */
    fun getDummyLectureData(): List<LectureObject> {
        return DummyLectures.lectures
    }
}

