package com.bajapuik.personal.data.datasource

import com.bajapuik.personal.data.datasource.response.TestimonialsResponse

interface PersonalDataSource {
    suspend fun getTestimonials(): List<TestimonialsResponse>
}