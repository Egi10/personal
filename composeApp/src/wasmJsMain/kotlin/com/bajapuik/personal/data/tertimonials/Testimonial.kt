package com.bajapuik.personal.data.tertimonials

import org.jetbrains.compose.resources.DrawableResource

data class Testimonial(
    val message: String,
    val name: String,
    val role: String,
    val image: DrawableResource?
)

object TestimonialData {
    val testimonials = listOf(
        Testimonial(
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis egestas rhoncus.",
            name = "Alice Smith",
            role = "Founder - xyz.com",
            image = null
        ),
        Testimonial(
            message = "Suspendisse potenti. Vivamus at arcu ut lacus dictum sodales non et ligula.",
            name = "Bob Johnson",
            role = "Founder - abc.com",
            image = null
        ),
        Testimonial(
            message = "Curabitur dignissim nisi et libero iaculis, id cursus felis mattis. Aenean non odio orci.",
            name = "Charlie Brown",
            role = "Freelancer",
            image = null
        ),
        Testimonial(
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis egestas rhoncus.",
            name = "David Wilson",
            role = "Founder - xyz.com",
            image = null
        ),
        Testimonial(
            message = "Suspendisse potenti. Vivamus at arcu ut lacus dictum sodales non et ligula.",
            name = "Emma Davis",
            role = "Founder - abc.com",
            image = null
        ),
        Testimonial(
            message = "Curabitur dignissim nisi et libero iaculis, id cursus felis mattis. Aenean non odio orci.",
            name = "Frank Miller",
            role = "Freelancer",
            image = null
        )
    )
}