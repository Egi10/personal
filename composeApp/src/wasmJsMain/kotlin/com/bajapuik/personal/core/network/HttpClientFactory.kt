package com.bajapuik.personal.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.http.appendPathSegments
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
    fun create(
        json: Json,
        baseUrl: String,
        path: String
    ): HttpClient {
        return HttpClient(Js) {
            install(ContentNegotiation) {
                json(
                    json = json
                )
            }

            defaultRequest {
                host = baseUrl

                url {
                    this.user
                    protocol = URLProtocol.HTTPS

                    appendPathSegments(path)
                }
            }
        }
    }
}