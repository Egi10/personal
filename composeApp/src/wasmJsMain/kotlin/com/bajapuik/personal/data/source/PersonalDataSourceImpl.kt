package com.bajapuik.personal.data.source

import com.bajapuik.personal.data.source.response.ExperiencesResponse
import com.bajapuik.personal.data.source.response.TestimonialsResponse
import com.bajapuik.personal.data.source.response.WorksResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PersonalDataSourceImpl(
    private val httpClient: HttpClient
) : PersonalDataSource {
    override suspend fun getExperiences(): List<ExperiencesResponse> {
        return httpClient.get("experiences.json")
            .body()
    }

    override suspend fun getWorks(): List<WorksResponse> {
        return httpClient.get("work.json")
            .body()
    }

    override suspend fun getTestimonials(): List<TestimonialsResponse> {
        return httpClient.get("testimonials.json")
            .body()
    }
}