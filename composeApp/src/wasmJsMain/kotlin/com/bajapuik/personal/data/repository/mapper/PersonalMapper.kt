package com.bajapuik.personal.data.repository.mapper

import com.bajapuik.personal.data.source.response.TestimonialsResponse
import com.bajapuik.personal.data.source.response.WorksResponse
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work

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