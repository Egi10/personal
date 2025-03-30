package com.bajapuik.personal

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.data.experience.ExperienceData
import com.bajapuik.personal.data.personal.PersonalData
import com.bajapuik.personal.data.skils.SkillsData
import com.bajapuik.personal.data.tertimonials.TestimonialData
import com.bajapuik.personal.data.work.WorkData
import com.bajapuik.personal.screen.main.DesktopScreen
import com.bajapuik.personal.screen.main.MobileScreen

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {
    val windowSizeClass = calculateWindowSizeClass()
    val widthSizeClass = windowSizeClass.widthSizeClass

    val experiences = ExperienceData.experiences
    val works = WorkData.work
    val testimonials = TestimonialData.testimonials
    val personal = PersonalData.personal
    val skills = SkillsData.skills

    PersonalTheme(
        windowWidthSizeClass = widthSizeClass
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxWidth(),
            containerColor = PersonalTheme.colors.default
        ) { paddingValues ->
            when (widthSizeClass) {
                WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {
                    // Mobile View
                    MobileScreen(
                        personal = personal,
                        skills = skills,
                        experiences = experiences,
                        works = works,
                        testimonials = testimonials,
                        modifier = Modifier
                            .padding(
                                paddingValues = paddingValues
                            )
                    )
                }

                WindowWidthSizeClass.Expanded -> {
                    // Tablet And Desktop View (All Sections in One Screen)
                    DesktopScreen(
                        skills = skills,
                        experiences = experiences,
                        works = works,
                        testimonials = testimonials,
                        personal = personal,
                        modifier = Modifier
                            .padding(
                                paddingValues = paddingValues
                            )
                    )
                }
            }
        }
    }
}