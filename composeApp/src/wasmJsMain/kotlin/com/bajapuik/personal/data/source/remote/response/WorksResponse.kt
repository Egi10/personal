package com.bajapuik.personal.data.source.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorksResponse(
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("projectUrl")
    val projectUrl: String?,
    @SerialName("technologies")
    val technologies: List<String>
)