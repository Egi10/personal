package com.bajapuik.personal.data.work

import org.jetbrains.compose.resources.DrawableResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.img_accurate_pos_playstore
import personal.composeapp.generated.resources.img_efeeder_playstore

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
            name = "Accurate POS",
            description = "POS application: manage customers & sales, employee management, all within Accurate's complete business ecosystem.",
            technologies = listOf(
                "Kotlin", "Jetpack Compose", "Kotlin Coroutines", "Point of Sale (POS) Systems"
            ),
            image = Res.drawable.img_accurate_pos_playstore,
            projectUrl = "https://play.google.com/store/apps/details?id=com.cpssoft.mobile.titan&hl=id"
        )
    )
}


