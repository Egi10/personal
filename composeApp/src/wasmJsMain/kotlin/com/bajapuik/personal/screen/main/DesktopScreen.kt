package com.bajapuik.personal.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.calculateResponsivePadding
import com.bajapuik.personal.data.experience.Experience
import com.bajapuik.personal.data.personal.Personal
import com.bajapuik.personal.data.skils.Skills
import com.bajapuik.personal.data.tertimonials.Testimonial
import com.bajapuik.personal.data.work.Work
import com.bajapuik.personal.screen.main.component.aboutme.DesktopAboutMe
import com.bajapuik.personal.screen.main.component.experience.DesktopExperience
import com.bajapuik.personal.screen.main.component.footer.Footer
import com.bajapuik.personal.screen.main.component.getintouch.GetInTouch
import com.bajapuik.personal.screen.main.component.header.DesktopHeader
import com.bajapuik.personal.screen.main.component.profile.DesktopProfile
import com.bajapuik.personal.screen.main.component.skill.DesktopSkills
import com.bajapuik.personal.screen.main.component.testimonials.DesktopTestimonials
import com.bajapuik.personal.screen.main.component.work.DesktopWork

@Composable
fun DesktopScreen(
    skills: List<Skills>,
    experiences: List<Experience>,
    works: List<Work>,
    testimonials: List<Testimonial>,
    personal: Personal,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        val columnWidth = min(maxWidth, 1440.dp)

        val breakpoints = mapOf(
            0.dp to 0.08f,     // <600dp: 8%
            600.dp to 0.00f,   // 600-900dp: 0%
            900.dp to 0.02f,   // 900-1280dp: 2%
            1280.dp to 0.05f,  // 1280-1440dp: 5%
            1440.dp to 0.08f   // >1440dp: 8%
        )

        val horizontalPadding = calculateResponsivePadding(
            columnWidth = columnWidth,
            breakpoints = breakpoints,
            defaultMultiplier = 0.08f
        )

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DesktopHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.default
                    )
                    .padding(
                        vertical = 16.dp,
                        horizontal = horizontalPadding
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DesktopProfile(
                    personal = personal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.default
                        )
                        .padding(
                            vertical = 96.dp,
                            horizontal = horizontalPadding
                        )
                )

                DesktopAboutMe(
                    personal = personal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.gray50
                        )
                        .padding(
                            vertical = 96.dp,
                            horizontal = horizontalPadding
                        )
                )

                DesktopSkills(
                    skills = skills,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.default
                        )
                        .padding(
                            vertical = 96.dp,
                            horizontal = horizontalPadding
                        )
                )

                DesktopExperience(
                    experiences = experiences,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.gray50
                        )
                        .padding(
                            vertical = 96.dp,
                            horizontal = horizontalPadding
                        )
                )

                DesktopWork(
                    works = works,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.default
                        )
                        .padding(
                            vertical = 96.dp,
                            horizontal = horizontalPadding
                        )
                )

                DesktopTestimonials(
                    testimonials = testimonials,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.gray50
                        )
                        .padding(
                            vertical = 96.dp,
                            horizontal = horizontalPadding
                        )
                )

                GetInTouch(
                    personal = personal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.default
                        )
                        .padding(
                            horizontal = horizontalPadding,
                            vertical = 96.dp
                        )
                )

                Footer(
                    name = personal.fullName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = PersonalTheme.colors.gray50
                        )
                        .padding(
                            vertical = 24.dp,
                            horizontal = horizontalPadding
                        )
                )
            }
        }
    }
}