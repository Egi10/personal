package com.bajapuik.personal.data.repository.mapper

import com.bajapuik.personal.data.source.response.ExperiencesResponse
import com.bajapuik.personal.data.source.response.PersonalResponse
import com.bajapuik.personal.data.source.response.SkillsResponse
import com.bajapuik.personal.data.source.response.TestimonialsResponse
import com.bajapuik.personal.data.source.response.WorksResponse
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Personal
import com.bajapuik.personal.domain.model.Skills
import com.bajapuik.personal.domain.model.SocialMedia
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work

internal fun PersonalResponse.asPersonalDomainModel(): Personal {
    return Personal(
        image = imageProfile,
        imageAboutMe = imageAboutMe,
        fullName = fullName,
        email = email,
        phoneNumber = phoneNumber,
        address = address,
        summary = summary,
        aboutMe = aboutMe,
        socialMedia = socialMediaResponse.map {
            SocialMedia(
                platform = it.platform,
                url = it.url,
                icon = it.icon
            )
        }
    )
}
internal fun List<SkillsResponse>.asSkillsDomainModel(): List<Skills> {
    return this.map {
        Skills(
            name = it.name,
            icon = it.icon,
            link = it.link
        )
    }
}

internal fun List<ExperiencesResponse>.asExperienceDomainModel(): List<Experience> {
    return this.map {
        Experience(
            company = it.companyImage,
            position = it.position,
            startDate = it.startDate,
            endDate = it.endDate,
            descriptions = it.descriptions
        )
    }
}

internal fun List<WorksResponse>.asWorkDomainModel(): List<Work> {
    return this.map {
        Work(
            name = it.name,
            description = it.description,
            technologies = it.technologies,
            image = it.image,
            projectUrl = it.projectUrl
        )
    }
}

internal fun List<TestimonialsResponse>.asTestimonialDomainModel(): List<Testimonial> {
    return this.map {
        Testimonial(
            message = it.message,
            name = it.name,
            role = it.role,
            image = it.image
        )
    }
}