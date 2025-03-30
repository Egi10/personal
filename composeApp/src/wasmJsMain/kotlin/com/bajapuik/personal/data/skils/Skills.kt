package com.bajapuik.personal.data.skils

import org.jetbrains.compose.resources.DrawableResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.compose_multiplatform
import personal.composeapp.generated.resources.img_firebase
import personal.composeapp.generated.resources.img_flutter
import personal.composeapp.generated.resources.img_git
import personal.composeapp.generated.resources.img_java
import personal.composeapp.generated.resources.img_jetpack_compose
import personal.composeapp.generated.resources.img_kotlin
import personal.composeapp.generated.resources.img_swift

data class Skills(
    val name: String,
    val icon: DrawableResource,
    val link: String
)

object SkillsData {
    val skills = listOf(
        Skills(
            name = "Kotlin",
            icon = Res.drawable.img_kotlin,
            link = "https://kotlinlang.org/"
        ),
        Skills(
            name = "Compose",
            icon = Res.drawable.img_jetpack_compose,
            link = "https://developer.android.com/jetpack/compose"
        ),
        Skills(
            name = "Firebase",
            icon = Res.drawable.img_firebase,
            link = "https://firebase.google.com/"
        ),
        Skills(
            name = "Java",
            icon = Res.drawable.img_java,
            link = "https://developer.android.com/jetpack/compose"
        ),
        Skills(
            name = "Flutter",
            icon = Res.drawable.img_flutter,
            link = "https://developer.android.com/jetpack/compose"
        ),
        Skills(
            name = "Swift",
            icon = Res.drawable.img_swift,
            link = "https://developer.android.com/jetpack/compose"
        ),
        Skills(
            name = "Git",
            icon = Res.drawable.img_git,
            link = "https://developer.android.com/jetpack/compose"
        )
    )
}
