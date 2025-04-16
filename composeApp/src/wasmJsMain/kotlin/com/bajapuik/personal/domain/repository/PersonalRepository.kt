package com.bajapuik.personal.domain.repository

import com.bajapuik.personal.domain.model.Personal
import com.bajapuik.personal.domain.model.Skills
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.domain.model.Testimonial

interface PersonalRepository {
    suspend fun getPersonal(): Personal
    suspend fun getSkills(): List<Skills>
    suspend fun getExperiences(): List<Experience>
    suspend fun getWorks(): List<Work>
    suspend fun getTestimonials(): List<Testimonial>
}