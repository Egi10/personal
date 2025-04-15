package com.bajapuik.personal.screen.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.data.personal.Personal
import com.bajapuik.personal.data.skils.Skills
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.screen.home.component.aboutme.MobileAboutMe
import com.bajapuik.personal.screen.home.component.experience.MobileExperience
import com.bajapuik.personal.screen.home.component.footer.Footer
import com.bajapuik.personal.screen.home.component.getintouch.GetInTouch
import com.bajapuik.personal.screen.home.component.header.MobileHeader
import com.bajapuik.personal.screen.home.component.profile.MobileProfile
import com.bajapuik.personal.screen.home.component.skill.MobileSkills
import com.bajapuik.personal.screen.home.component.testimonials.MobileTestimonials
import com.bajapuik.personal.screen.home.component.work.MobileWork

@Composable
fun HomeMobile(
    personal: Personal,
    skills: List<Skills>,
    experiences: List<Experience>,
    works: List<Work>,
    testimonials: List<Testimonial>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        MobileHeader(
            onMenuClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    all = 16.dp
                )
        )

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            MobileProfile(
                personal = personal,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.default
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 64.dp
                    )
            )

            MobileAboutMe(
                personal = personal,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.gray50
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 64.dp
                    )
            )

            MobileSkills(
                skills = skills,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.default
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 64.dp
                    )
            )

            MobileExperience(
                experiences = experiences,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.gray50
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 64.dp
                    )
            )

            MobileWork(
                works = works,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.default
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 64.dp
                    )
            )

            MobileTestimonials(
                testimonials = testimonials,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = PersonalTheme.colors.gray50
                    )
                    .padding(
                        horizontal = 16.dp,
                        vertical = 64.dp
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
                        horizontal = 16.dp,
                        vertical = 64.dp

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
                        vertical = 24.dp
                    )
            )
        }
    }
}