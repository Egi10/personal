package com.bajapuik.personal.domain.model

data class Work(
    val name: String,
    val description: String,
    val technologies: List<String>,
    val image: String,
    val projectUrl: String?
)


