package com.bajapuik.personal.screen.home.utils

import org.jetbrains.compose.resources.StringResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.section_about
import personal.composeapp.generated.resources.section_contact
import personal.composeapp.generated.resources.section_testimonial
import personal.composeapp.generated.resources.section_work

enum class Section(val titleRes: StringResource) {
    ABOUT(Res.string.section_about),
    WORK(Res.string.section_work),
    TESTIMONIAL(Res.string.section_testimonial),
    CONTACT(Res.string.section_contact)
}
