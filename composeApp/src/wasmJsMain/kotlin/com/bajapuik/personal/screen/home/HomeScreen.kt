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
    val works by viewModel.worksUiState.collectAsStateWithLifecycle()
    val experiences by viewModel.experiencesUiState.collectAsStateWithLifecycle()
    val skills by viewModel.skillsUiState.collectAsStateWithLifecycle()
    val personal by viewModel.personalUiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .fillMaxWidth(),
        containerColor = PersonalTheme.colors.default
    ) { paddingValues ->
        personal?.let {
            when (windowWidthSizeClass) {
                WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {
                    // Mobile View
                    HomeMobile(
                        personal = it,
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
                        personal = it,
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