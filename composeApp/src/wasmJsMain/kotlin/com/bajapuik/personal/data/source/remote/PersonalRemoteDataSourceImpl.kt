package com.bajapuik.personal.data.source.remote

import com.bajapuik.personal.data.source.remote.response.ExperiencesResponse
import com.bajapuik.personal.data.source.remote.response.PersonalResponse
import com.bajapuik.personal.data.source.remote.response.SkillsResponse
import com.bajapuik.personal.data.source.remote.response.TestimonialsResponse
import com.bajapuik.personal.data.source.remote.response.WorksResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PersonalRemoteDataSourceImpl(
    private val httpClient: HttpClient
) : PersonalRemoteDataSource {
    override suspend fun getPersonal(): PersonalResponse {
        return httpClient.get("personal.json")
            .body()
    }

    override suspend fun getSkills(): List<SkillsResponse> {
        return httpClient.get("skills.json")
            .body()
    }

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