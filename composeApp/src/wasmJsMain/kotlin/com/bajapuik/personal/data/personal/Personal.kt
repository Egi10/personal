package com.bajapuik.personal.data.personal

import org.jetbrains.compose.resources.DrawableResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_profile

data class Personal(
    val image: DrawableResource,
    val fullName: String,
    val email: String,
    val phoneNumber: String,
    val linkedIn: String,
    val medium: String,
    val github: String,
    val address: String,
    val summary: String,
    val aboutMe: List<String>
)

object PersonalData {
    val personal = Personal(
        image = Res.drawable.img_profile,
        fullName = "Julsapargi Nursam",
        email = "julsaparginursam@gmail.com",
        phoneNumber = "+62 82382127489",
        linkedIn = "https://www.linkedin.com/in/julsapargi-nursam/",
        medium = "https://medium.com/@julsapargi_nursam",
        github = "https://github.com/Egi10",
        address = "West Sumatra, Indonesia",
        summary = "I'm a Mobile App Developer specializing in Android and Kotlin Multiplatform, with a focus on building high-quality, user-centric applications that are fast, intuitive, and scalable. With over five years of experience, I am passionate about crafting seamless digital experiences through clean architecture, efficient code, and modern best practices. Recently, I have expanded my expertise to iOS development using Swift and SwiftUI, further enhancing my ability to create cross-platform and native mobile solutions.",
        aboutMe = listOf(
            "I am a passionate Mobile App Developer specializing in Android, with over five years of experience building high-quality, user-centric applications. Since 2018, I have been dedicated to developing scalable and maintainable Android solutions using modern best practices.",
            "In 2023, I expanded my expertise to Kotlin Multiplatform and Compose Multiplatform, enabling seamless code-sharing and efficient cross-platform development for both Android and iOS. My focus is on writing clean, efficient, and well-structured code to deliver smooth and intuitive user experiences.",
            "Currently, I am enhancing my proficiency in Swift and SwiftUI to further strengthen my ability to create fully native iOS applications. With a commitment to continuous learning and innovation, I strive to stay ahead of industry trends and develop cutting-edge mobile solutions."
        )
    )
}
