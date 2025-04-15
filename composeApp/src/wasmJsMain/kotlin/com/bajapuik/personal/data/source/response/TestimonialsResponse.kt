package com.bajapuik.personal.data.source.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TestimonialsResponse(
    @SerialName("image")
    val image: String,
    @SerialName("message")
    val message: String,
    @SerialName("name")
    val name: String,
    @SerialName("role")
    val role: String
)