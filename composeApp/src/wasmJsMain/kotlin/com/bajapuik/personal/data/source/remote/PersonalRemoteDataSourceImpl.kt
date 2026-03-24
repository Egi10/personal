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
    override suspend fun getPersonal(language: String): PersonalResponse {
        return httpClient.get("${language}/personal.json")
            .body()
    }

    override suspend fun getSkills(language: String): List<SkillsResponse> {
        return httpClient.get("${language}/skills.json")
            .body()
    }

    override suspend fun getExperiences(language: String): List<ExperiencesResponse> {
        return httpClient.get("${language}/experiences.json")
            .body()
    }

    override suspend fun getWorks(language: String): List<WorksResponse> {
        return httpClient.get("${language}/work.json")
            .body()
    }

    override suspend fun getTestimonials(language: String): List<TestimonialsResponse> {
        return httpClient.get("${language}/testimonials.json")
            .body()
    }
}