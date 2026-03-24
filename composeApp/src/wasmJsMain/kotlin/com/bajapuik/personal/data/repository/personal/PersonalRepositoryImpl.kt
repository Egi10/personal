package com.bajapuik.personal.data.repository.personal

import com.bajapuik.personal.data.repository.personal.mapper.asExperienceDomainModel
import com.bajapuik.personal.data.repository.personal.mapper.asPersonalDomainModel
import com.bajapuik.personal.data.repository.personal.mapper.asSkillsDomainModel
import com.bajapuik.personal.data.repository.personal.mapper.asTestimonialDomainModel
import com.bajapuik.personal.data.repository.personal.mapper.asWorkDomainModel
import com.bajapuik.personal.data.source.local.PersonalLocalDataSource
import com.bajapuik.personal.data.source.remote.PersonalRemoteDataSource
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Personal
import com.bajapuik.personal.domain.model.Skills
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.domain.repository.PersonalRepository

class PersonalRepositoryImpl(
    private val personalRemoteDataSource: PersonalRemoteDataSource,
    private val personalLocalDataSource: PersonalLocalDataSource
) : PersonalRepository {
    override suspend fun getPersonal(): Personal {
        return personalRemoteDataSource.getPersonal(
            language = getLanguage()
        ).asPersonalDomainModel()
    }

    override suspend fun getSkills(): List<Skills> {
        return personalRemoteDataSource.getSkills(
            language = getLanguage()
        ).asSkillsDomainModel()
    }

    override suspend fun getExperiences(): List<Experience> {
        return personalRemoteDataSource.getExperiences(
            language = getLanguage()
        ).asExperienceDomainModel()
    }

    override suspend fun getWorks(): List<Work> {
        return personalRemoteDataSource.getWorks(
            language = getLanguage()
        ).asWorkDomainModel()
    }

    override suspend fun getTestimonials(): List<Testimonial> {
        return personalRemoteDataSource.getTestimonials(
            language = getLanguage()
        ).asTestimonialDomainModel()
    }

    private suspend fun getLanguage() = personalLocalDataSource.getLanguage()
}