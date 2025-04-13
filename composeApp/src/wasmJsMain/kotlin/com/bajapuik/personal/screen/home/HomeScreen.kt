package com.bajapuik.personal.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bajapuik.personal.core.designsystem.theme.PersonalTheme
import com.bajapuik.personal.data.experience.ExperienceData
import com.bajapuik.personal.data.personal.PersonalData
import com.bajapuik.personal.data.skils.SkillsData
import com.bajapuik.personal.data.work.WorkData
import com.bajapuik.personal.screen.home.event.HomeEvent
import com.bajapuik.personal.screen.home.ui.HomeDesktop
import com.bajapuik.personal.screen.home.ui.HomeMobile
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel = koinViewModel<HomeViewModel>()

    LaunchedEffect(Unit) {
        viewModel.onEvent(
            event = HomeEvent.Init
        )
    }

    val testimonials by viewModel.testimonialsUiState.collectAsStateWithLifecycle()

    val experiences = ExperienceData.experiences
    val works = WorkData.work
    val personal = PersonalData.personal
    val skills = SkillsData.skills

    Scaffold(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = PersonalTheme.colors.default
    ) { paddingValues ->
        when (windowWidthSizeClass) {
            WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {
                // Mobile View
                HomeMobile(
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
                HomeDesktop(
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