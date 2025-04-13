package com.bajapuik.personal.data.datasource

import com.bajapuik.personal.data.datasource.response.TestimonialsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PersonalDataSourceImpl(
    private val httpClient: HttpClient
) : PersonalDataSource {
    override suspend fun getTestimonials(): List<TestimonialsResponse> {
        return httpClient.get("testimonials.json")
            .body()
    }
}