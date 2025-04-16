package com.bajapuik.personal.data.source.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonalResponse(
    @SerialName("aboutMe")
    val aboutMe: List<String>,
    @SerialName("address")
    val address: String,
    @SerialName("email")
    val email: String,
    @SerialName("fullName")
    val fullName: String,
    @SerialName("imageAboutMe")
    val imageAboutMe: String,
    @SerialName("imageProfile")
    val imageProfile: String,
    @SerialName("phoneNumber")
    val phoneNumber: String,
    @SerialName("socialMedia")
    val socialMediaResponse: List<SocialMediaResponse>,
    @SerialName("summary")
    val summary: String
)

@Serializable
data class SocialMediaResponse(
    @SerialName("icon")
    val icon: String,
    @SerialName("platform")
    val platform: String,
    @SerialName("url")
    val url: String
)