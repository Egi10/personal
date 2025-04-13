package com.bajapuik.personal.data.repository

import com.bajapuik.personal.data.datasource.PersonalDataSource
import com.bajapuik.personal.data.repository.mapper.asTestimonialDomainModel
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.repository.PersonalRepository

class PersonalRepositoryImpl(
    private val personalDataSource: PersonalDataSource
) : PersonalRepository {
    override suspend fun getTestimonials(): List<Testimonial> {
        return personalDataSource.getTestimonials()
            .asTestimonialDomainModel()
    }
}