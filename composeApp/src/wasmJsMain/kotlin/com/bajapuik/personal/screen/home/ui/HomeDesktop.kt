package com.bajapuik.personal.screen.home.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.ui.calculateResponsivePadding
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Personal
import com.bajapuik.personal.domain.model.Skills
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.screen.home.component.aboutme.DesktopAboutMe
import com.bajapuik.personal.screen.home.component.experience.DesktopExperience
import com.bajapuik.personal.screen.home.component.footer.Footer
import com.bajapuik.personal.screen.home.component.getintouch.GetInTouch
import com.bajapuik.personal.screen.home.component.header.DesktopHeader
import com.bajapuik.personal.screen.home.component.profile.DesktopProfile
import com.bajapuik.personal.screen.home.component.skill.DesktopSkills
import com.bajapuik.personal.screen.home.component.testimonials.DesktopTestimonials
import com.bajapuik.personal.screen.home.component.work.DesktopWork
import com.bajapuik.personal.screen.home.utils.Section
import kotlinx.coroutines.launch

@Composable
fun HomeDesktop(
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
        /**
         * TODO : Adjust layout margins to match the web design at https://sagarshah.dev/
         * On larger screens, the margins are still inconsistent
         * Review the responsive layout rules and ensure a consistent max content width
         */
        val breakpoints = mapOf(
            0.dp to 0.08f,     // <600dp: 8%
            600.dp to 0.00f,   // 600-900dp: 0%
            900.dp to 0.02f,   // 900-1280dp: 2%
            1280.dp to 0.05f,  // 1280-1440dp: 5%
            1440.dp to 0.08f   // >1440dp: 8%
        )

        val horizontalPadding = calculateResponsivePadding(
            columnWidth = maxWidth,
            breakpoints = breakpoints,
            defaultMultiplier = 0.08f
        )

        val scrollState = rememberScrollState()
        val isScrolled by remember {
            derivedStateOf {
                scrollState.value > 0
            }
        }
        val scope = rememberCoroutineScope()
        val density = LocalDensity.current

        var profileOffset by remember { mutableStateOf(0) }
        var aboutMeOffset by remember { mutableStateOf(0) }
        var contactOffset by remember { mutableStateOf(0) }
        var workOffset by remember { mutableStateOf(0) }
        var testimonialOffset by remember { mutableStateOf(0) }

        var headerHeightPx by remember { mutableStateOf(0) }

        Box(
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(
                        top = with(density) {
                            headerHeightPx.toDp()
                        }
                    ),
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
                        .onGloballyPositioned { coordinates ->
                            profileOffset = coordinates.positionInParent().y.toInt()
                        }
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
                        .onGloballyPositioned { coordinates ->
                            aboutMeOffset = coordinates.positionInParent().y.toInt()
                        }
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
                        .onGloballyPositioned { coordinates ->
                            workOffset = coordinates.positionInParent().y.toInt()
                        }
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
                        .onGloballyPositioned { coordinates ->
                            testimonialOffset = coordinates.positionInParent().y.toInt()
                        }
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
                        .onGloballyPositioned { coordinates ->
                            contactOffset = coordinates.positionInParent().y.toInt()
                        }
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { layoutCoordinates ->
                    headerHeightPx = layoutCoordinates.size.height
                }
        ) {
            DesktopHeader(
                name = personal.fullName,
                onInitialClick = {
                    scope.launch {
                        scrollState.animateScrollTo(
                            profileOffset,
                            animationSpec = tween(
                                durationMillis = 500,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                },
                onSectionClick = {
                    scope.launch {
                        val rawOffset = when (it) {
                            Section.ABOUT -> aboutMeOffset
                            Section.WORK -> workOffset
                            Section.TESTIMONIAL -> testimonialOffset
                            Section.CONTACT -> contactOffset
                        }

                        val offsetWithSpacing = rawOffset - with(density) {
                            16.dp.toPx()
                        }.toInt()
                        scrollState.animateScrollTo(
                            offsetWithSpacing,
                            animationSpec = tween(
                                durationMillis = 500,
                                easing = FastOutSlowInEasing
                            )
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .glassBackground(
                        isScrolled = isScrolled,
                        color = PersonalTheme.colors.default,
                        dividerColor = PersonalTheme.colors.gray100
                    )
                    .padding(
                        vertical = 16.dp,
                        horizontal = horizontalPadding
                    )
            )
        }
    }
}

/**
 * TODO : Add Effect Blur
 */
private fun Modifier.glassBackground(
    isScrolled: Boolean,
    color: Color,
    dividerColor: Color,
    blurSimulationAlpha: Float = 0.95f
): Modifier = composed {
    this
        .background(
            color = color.copy(
                alpha = if (isScrolled) blurSimulationAlpha else 0f
            )
        )
        .drawBehind {
            if (isScrolled) {
                drawLine(
                    color = dividerColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
}