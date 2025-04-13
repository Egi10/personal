package com.bajapuik.personal.data.repository.mapper

import com.bajapuik.personal.data.datasource.response.TestimonialsResponse
import com.bajapuik.personal.domain.model.Testimonial

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