package com.bajapuik.personal.data.work

import org.jetbrains.compose.resources.DrawableResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_accurate_lite_playstore
import personal.composeapp.generated.resources.img_accurate_pos_playstore
import personal.composeapp.generated.resources.img_efeeder_playstore
import personal.composeapp.generated.resources.img_mets_playstore
import personal.composeapp.generated.resources.img_si_spesial

data class Work(
    val name: String,
    val description: String,
    val technologies: List<String>,
    val image: DrawableResource,
    val projectUrl: String?
)

object WorkData {
    val work = listOf(
        Work(
            name = "eFeeder: Smart Auto Feeder",
            description = "eFeeder is an automatic fish and shrimp feeding machine that provides a feeding solution for aquaculture.",
            technologies = listOf(
                "Kotlin Multiplatform", "Compose Multiplatform", "Kotlin Coroutines", "Ktor",
                "SQLDelight", "Firebase"
            ),
            image = Res.drawable.img_efeeder_playstore,
            projectUrl = "https://play.google.com/store/apps/details/eFeeder_Smart_Auto_Feeder?id=cybreed.efisheryprototype&hl=id"
        ),
        Work(
            name = "Si Spesial",
            description = "SI SPESIAL is a system that serves as an information hub related to National Conservation Areas in Western Indonesia.",
            technologies = listOf(
                "Kotlin", "Jetpack Compose", "Kotlin Coroutines", "Ktor",
                "Open Street Map", "Firebase"
            ),
            image = Res.drawable.img_si_spesial,
            projectUrl = null
        ),
        Work(
            name = "Accurate POS",
            description = "POS application: manage customers & sales, employee management, all within Accurate's complete business ecosystem.",
            technologies = listOf(
                "Kotlin", "Retrofit", "Jetpack Compose", "Kotlin Coroutines", "Point of Sale (POS) Systems"
            ),
            image = Res.drawable.img_accurate_pos_playstore,
            projectUrl = "https://play.google.com/store/apps/details?id=com.cpssoft.mobile.titan&hl=id"
        ),
        Work(
            name = "Accurate Lite",
            description = "Accurate Lite is a user-friendly mobile business application for small and medium enterprises. Create invoices, check stock and prices, and view financial reports anytime, anywhere.",
            technologies = listOf(
                "Kotlin", "Retrofit", "RxJava", "Android Jetpack"
            ),
            image = Res.drawable.img_accurate_lite_playstore,
            projectUrl = "https://play.google.com/store/apps/details?id=com.cpssoft.mobile.alpha&hl=id"
        ),
        Work(
            name = "METs-Mitigasi Evakuasi Tsunami",
            description = "METS - Tsunami Evacuation Mitigation app a helper application in the face of disaster tsunami evacuation (case study: Padang) that contains information about the location of vertical evacuation in this case building a decent shelter and other necessary information.",
            technologies = listOf(
                "Java", "Retrofit", "Google Map"
            ),
            image = Res.drawable.img_mets_playstore,
            projectUrl = "https://play.google.com/store/apps/details?id=com.app.phedev.tsunamimitigasi&hl=id"
        )
    )
}


