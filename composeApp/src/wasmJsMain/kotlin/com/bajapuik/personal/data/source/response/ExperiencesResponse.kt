package com.bajapuik.personal.data.source.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExperiencesResponse(
    @SerialName("companyImage")
    val companyImage: String,
    @SerialName("descriptions")
    val descriptions: List<String>,
    @SerialName("endDate")
    val endDate: String?,
    @SerialName("position")
    val position: String,
    @SerialName("startDate")
    val startDate: String
)