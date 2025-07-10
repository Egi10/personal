package com.bajapuik.personal.data.source.remote

import com.bajapuik.personal.data.source.remote.response.ExperiencesResponse
import com.bajapuik.personal.data.source.remote.response.PersonalResponse
import com.bajapuik.personal.data.source.remote.response.SkillsResponse
import com.bajapuik.personal.data.source.remote.response.TestimonialsResponse
import com.bajapuik.personal.data.source.remote.response.WorksResponse

interface PersonalRemoteDataSource {
    suspend fun getPersonal(): PersonalResponse
    suspend fun getSkills(): List<SkillsResponse>
    suspend fun getExperiences(): List<ExperiencesResponse>
    suspend fun getWorks(): List<WorksResponse>
    suspend fun getTestimonials(): List<TestimonialsResponse>
}