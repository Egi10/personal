package com.bajapuik.personal.domain.repository

import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.domain.model.Testimonial

interface PersonalRepository {
    suspend fun getWorks(): List<Work>
    suspend fun getTestimonials(): List<Testimonial>
}