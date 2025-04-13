package com.bajapuik.personal.domain.repository

import com.bajapuik.personal.domain.model.Testimonial

interface PersonalRepository {
    suspend fun getTestimonials(): List<Testimonial>
}