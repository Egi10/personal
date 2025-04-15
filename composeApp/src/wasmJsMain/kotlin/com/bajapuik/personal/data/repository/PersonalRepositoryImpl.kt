package com.bajapuik.personal.data.repository

import com.bajapuik.personal.data.repository.mapper.asExperienceDomainModel
import com.bajapuik.personal.data.repository.mapper.asSkillsDomainModel
import com.bajapuik.personal.data.source.PersonalDataSource
import com.bajapuik.personal.data.repository.mapper.asTestimonialDomainModel
import com.bajapuik.personal.data.repository.mapper.asWorkDomainModel
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Skills
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.domain.repository.PersonalRepository

class PersonalRepositoryImpl(
    private val personalDataSource: PersonalDataSource
) : PersonalRepository {
    override suspend fun getSkills(): List<Skills> {
        return personalDataSource.getSkills()
            .asSkillsDomainModel()
    }

    override suspend fun getExperiences(): List<Experience> {
        return personalDataSource.getExperiences()
            .asExperienceDomainModel()
    }

    override suspend fun getWorks(): List<Work> {
        return personalDataSource.getWorks()
            .asWorkDomainModel()
    }

    override suspend fun getTestimonials(): List<Testimonial> {
        return personalDataSource.getTestimonials()
            .asTestimonialDomainModel()
    }
}