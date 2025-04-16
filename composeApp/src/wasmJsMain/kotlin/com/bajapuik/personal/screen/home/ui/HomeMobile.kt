package com.bajapuik.personal.screen.home.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bajapuik.personal.core.designsystem.component.PersonalButton
import com.bajapuik.personal.core.designsystem.component.PersonalIconButtons
import com.bajapuik.personal.core.designsystem.component.PersonalRightModalNavigationDrawer
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.core.utils.NameUtils
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Personal
import com.bajapuik.personal.domain.model.Skills
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
import com.bajapuik.personal.screen.home.utils.Section
import com.bajapuik.personal.screen.home.utils.glassBackground
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import personal.composeapp.generated.resources.Res
import personal.composeapp.generated.resources.ic_close
import personal.composeapp.generated.resources.ic_dark_mode_light

@Composable
fun HomeMobile(
    personal: Personal,
    skills: List<Skills>,
    experiences: List<Experience>,
    works: List<Work>,
    testimonials: List<Testimonial>,
    modifier: Modifier = Modifier
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val scrollState = rememberScrollState()
    val isScrolled by remember {
        derivedStateOf {
            scrollState.value > 0
        }
    }

    var aboutMeOffset by remember { mutableStateOf(0) }
    var contactOffset by remember { mutableStateOf(0) }
    var workOffset by remember { mutableStateOf(0) }
    var testimonialOffset by remember { mutableStateOf(0) }

    var headerHeightPx by remember { mutableStateOf(0) }

    PersonalRightModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .navigationBarsPadding(),
                drawerShape = RoundedCornerShape(0.dp),
                drawerContainerColor = PersonalTheme.colors.default
            ) {
                DrawerMenu(
                    name = personal.fullName,
                    onCloseInitialClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    onSectionClick = {
                        scope.launch {
                            drawerState.close()

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
                    onSwitchThemeClick = {

                    },
                    onDownloadCvClick = {
                        scope.launch {
                            drawerState.close()
                        }

                        window.open(
                            "https://egi10.github.io/storage/resume/julsapargi_nursam.pdf",
                            "_blank"
                        )
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(320.dp)
                )
            }
        },
        drawerState = drawerState,
        content = {
            Box(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(scrollState)
                        .padding(
                            top = with(density) {
                                headerHeightPx.toDp()
                            }
                        )
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
                            .onGloballyPositioned { coordinates ->
                                aboutMeOffset = coordinates.positionInParent().y.toInt()
                            }
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
                            .onGloballyPositioned { coordinates ->
                                workOffset = coordinates.positionInParent().y.toInt()
                            }
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
                                horizontal = 16.dp,
                                vertical = 64.dp

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

                MobileHeader(
                    name = personal.fullName,
                    onMenuClick = {
                        scope.launch {
                            if (drawerState.isOpen) {
                                drawerState.close()
                            } else {
                                drawerState.open()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .glassBackground(
                            isScrolled = isScrolled,
                            color = PersonalTheme.colors.default,
                            dividerColor = PersonalTheme.colors.gray100
                        )
                        .onGloballyPositioned { layoutCoordinates ->
                            headerHeightPx = layoutCoordinates.size.height
                        }
                        .padding(
                            all = 16.dp
                        )
                )
            }
        }
    )
}

@Composable
private fun DrawerMenu(
    name: String,
    onCloseInitialClick: () -> Unit,
    onSectionClick: (Section) -> Unit,
    onSwitchThemeClick: () -> Unit,
    onDownloadCvClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Initials(
            name = name,
            onClick = onCloseInitialClick,
            modifier = Modifier
                .padding(
                    all = 16.dp
                )
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            color = PersonalTheme.colors.gray100
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    all = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Section.entries.forEach { section ->
                SectionItem(
                    item = section.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    onSectionClick.invoke(section)
                                }
                            )
                        }
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            color = PersonalTheme.colors.gray100
        )

        SwitchTheme(
            onClick = onSwitchThemeClick,
            modifier = Modifier
                .padding(
                    all = 16.dp
                )
        )

        PersonalButton(
            text = "Download CV",
            onClick = onDownloadCvClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        )
    }
}

@Composable
private fun Initials(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "<${NameUtils.getInitials(name)}/>",
            style = PersonalTheme.typography.headingH3,
            fontWeight = FontWeight.Bold,
            color = PersonalTheme.colors.gray900,
            modifier = Modifier
                .weight(1f)
        )

        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_close),
            onClick = onClick
        )
    }
}

@Composable
private fun SectionItem(
    item: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = item,
            style = PersonalTheme.typography.body2,
            fontWeight = FontWeight.Medium,
            color = PersonalTheme.colors.gray600
        )
    }
}

@Composable
private fun SwitchTheme(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Switch Theme",
            style = PersonalTheme.typography.body2,
            color = PersonalTheme.colors.gray600
        )

        PersonalIconButtons(
            icon = painterResource(Res.drawable.ic_dark_mode_light),
            onClick = onClick
        )
    }
}