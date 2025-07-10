package com.bajapuik.personal.data.source.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SkillsResponse(
    @SerialName("icon")
    val icon: String,
    @SerialName("link")
    val link: String,
    @SerialName("name")
    val name: String
)