package com.bajapuik.personal.data.source

import com.bajapuik.personal.data.source.response.ExperiencesResponse
import com.bajapuik.personal.data.source.response.TestimonialsResponse
import com.bajapuik.personal.data.source.response.WorksResponse

interface PersonalDataSource {
    suspend fun getExperiences(): List<ExperiencesResponse>
    suspend fun getWorks(): List<WorksResponse>
    suspend fun getTestimonials(): List<TestimonialsResponse>
}