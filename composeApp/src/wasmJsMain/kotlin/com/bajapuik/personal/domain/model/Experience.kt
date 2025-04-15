package com.bajapuik.personal.domain.model

data class Experience(
    val company: String,
    val position: String,
    val startDate: String,
    val endDate: String?,
    val descriptions: List<String>
)
