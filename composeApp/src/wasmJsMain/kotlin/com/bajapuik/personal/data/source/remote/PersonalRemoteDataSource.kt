package com.bajapuik.personal.data.source.remote

import com.bajapuik.personal.data.source.remote.response.ExperiencesResponse
import com.bajapuik.personal.data.source.remote.response.PersonalResponse
import com.bajapuik.personal.data.source.remote.response.SkillsResponse
import com.bajapuik.personal.data.source.remote.response.TestimonialsResponse
import com.bajapuik.personal.data.source.remote.response.WorksResponse

interface PersonalRemoteDataSource {
    suspend fun getPersonal(language: String): PersonalResponse
    suspend fun getSkills(language: String): List<SkillsResponse>
    suspend fun getExperiences(language: String): List<ExperiencesResponse>
    suspend fun getWorks(language: String): List<WorksResponse>
    suspend fun getTestimonials(language: String): List<TestimonialsResponse>
}