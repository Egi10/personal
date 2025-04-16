package com.bajapuik.personal.domain.model

data class Personal(
    val image: String,
    val imageAboutMe: String,
    val fullName: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val summary: String,
    val aboutMe: List<String>,
    val socialMedia: List<SocialMedia>
)

data class SocialMedia(
    val platform: String,
    val url: String,
    val icon: String
)
