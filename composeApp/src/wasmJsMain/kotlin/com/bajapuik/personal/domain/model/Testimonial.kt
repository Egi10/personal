package com.bajapuik.personal.domain.model

data class Testimonial(
    val message: String,
    val name: String,
    val role: String,
    val image: String?
)