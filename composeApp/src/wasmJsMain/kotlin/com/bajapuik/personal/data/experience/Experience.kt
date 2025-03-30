package com.bajapuik.personal.data.experience

import org.jetbrains.compose.resources.DrawableResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_accurate
import personal.composeapp.generated.resources.img_efishery
import personal.composeapp.generated.resources.img_mediatama
import personal.composeapp.generated.resources.img_mitrafin
import personal.composeapp.generated.resources.img_wowbid

data class Experience(
    val company: DrawableResource,
    val position: String,
    val startDate: String,
    val endDate: String?,
    val descriptions: List<String>
)

object ExperienceData {
    val experiences = listOf(
        Experience(
            company = Res.drawable.img_efishery,
            position = "Mobile Engineer - Android",
            startDate = "May 2022",
            endDate = "Mar 2025",
            descriptions = listOf(
                "Optimized eFeederApp: Refactored the codebase from Groovy to KotlinDSL, enhancing efficiency and development consistency.",
                "Streamlined Dependency Management: Migrated from Dagger2 to Hilt for simpler code and reduced boilerplate.",
                "Enabled Kotlin Multiplatform: Implemented Kotlin Multiplatform for eFeederApp across Android and iOS, enabling code sharing and reducing development time, with up to 70% code reuse between platforms.",
                "Expanded Skillset to iOS: Contributed to iOS project setup and integrated Kotlin Multiplatform, developing UI with SwiftUI.",
                "Conducted UI Research and Migration: Researched and migrated UI from XML to Compose Multiplatform, while transitioning the design system from OneFish v1 to OneFish v2.",
                "Continuously Improved Code Quality: Regularly refactored and optimized code for enhanced performance and maintainability."
            )
        ),
        Experience(
            company = Res.drawable.img_accurate,
            position = "Senior Mobile Engineer - Android",
            startDate = "Jan 2021",
            endDate = "Apr 2022",
            descriptions = listOf(
                "Led a team of 3 Android developers in delivering innovative features for our POS app.",
                "Architected and implemented modularization, significantly enhancing app structure and maintainability.",
                "Modernized the user interface by transitioning from XML to Jetpack Compose.",
                "Optimized codebase through refactoring and performance improvements.",
                "Ensured timely project delivery and adherence to coding standards."
            )
        ),
        Experience(
            company = Res.drawable.img_wowbid,
            position = "Android Developer",
            startDate = "Nov 2019",
            endDate = "Dec 2020",
            descriptions = listOf(
                "Develop Android applications (WOWBID) using Kotlin, implementing clean architecture and MVVM concepts.",
                "Assist in conducting research on Android app development."
            )
        ),
        Experience(
            company = Res.drawable.img_mediatama,
            position = "Android Developer",
            startDate = "Mar 2019",
            endDate = "Jul 2019",
            descriptions = listOf(
                "Create an Android App (Hemodialysis Diary, BP Paud Dismas Sumbar, Kasir Mediatama) using Kotlin with the MVP concept.",
                "Conduct tutoring for students who take private tutoring classes."
            )
        ),
        Experience(
            company = Res.drawable.img_mitrafin,
            position = "Staff IT - Development (Android Developers)",
            startDate = "Mar 2018",
            endDate = "Jan 2019",
            descriptions = listOf(
                "Rewrote Android apps APF Collector and BSM Collector from Java to Kotlin, implementing the MVP architecture.",
                "Developed Android app BSM Surveyor using Kotlin and MVP architecture.",
                "Maintained Android app Buana Multidana CRM App using Java."
            )
        )
    )
}
