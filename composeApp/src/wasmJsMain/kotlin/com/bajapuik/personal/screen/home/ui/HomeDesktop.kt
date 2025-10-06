package com.bajapuik.personal.screen.home.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.domain.model.*
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
import com.bajapuik.personal.screen.home.utils.glassBackground
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
                            vertical = 96.dp
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
                            vertical = 96.dp
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
                            vertical = 96.dp
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
                            vertical = 96.dp
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
                            vertical = 96.dp
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
                            vertical = 96.dp
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
                            vertical = 24.dp
                        )
                )
            }
        }

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
                    dividerColor = PersonalTheme.colors.gray100,
                    isDesktop = true,
                )
                .onGloballyPositioned { layoutCoordinates ->
                    headerHeightPx = layoutCoordinates.size.height
                }
                .padding(
                    vertical = 16.dp
                )
        )
    }
}