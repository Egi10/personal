package com.bajapuik.personal.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Personal
import com.bajapuik.personal.domain.model.Skills
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.domain.repository.PersonalRepository
import com.bajapuik.personal.screen.home.event.HomeEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val personalRepository: PersonalRepository
) : ViewModel() {

    private val _testimonialsUiState = MutableStateFlow<List<Testimonial>>(emptyList())
    val testimonialsUiState get() = _testimonialsUiState.asStateFlow()

    private val _worksUiState = MutableStateFlow<List<Work>>(emptyList())
    val worksUiState get() = _worksUiState.asStateFlow()

    private val _experiencesUiState = MutableStateFlow<List<Experience>>(emptyList())
    val experiencesUiState get() = _experiencesUiState.asStateFlow()

    private val _skillsUiState = MutableStateFlow<List<Skills>>(emptyList())
    val skillsUiState get() = _skillsUiState.asStateFlow()

    private val _personalUiState = MutableStateFlow<Personal?>(null)
    val personalUiState get() = _personalUiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Init -> {
                getTestimonials()
                getWorks()
                getExperiences()
                getSkills()
                getPersonal()
            }
        }
    }

    private fun getTestimonials() {
        viewModelScope.launch {
            val result = personalRepository.getTestimonials()

            _testimonialsUiState.update {
                result
            }
        }
    }

    private fun getWorks() {
        viewModelScope.launch {
            val result = personalRepository.getWorks()

            _worksUiState.update {
                result
            }
        }
    }

    private fun getExperiences() {
        viewModelScope.launch {
            val result = personalRepository.getExperiences()

            _experiencesUiState.update {
                result
            }
        }
    }

    private fun getSkills() {
        viewModelScope.launch {
            val result = personalRepository.getSkills()

            _skillsUiState.update {
                result
            }
        }
    }

    private fun getPersonal() {
        viewModelScope.launch {
            val result = personalRepository.getPersonal()

            _personalUiState.update {
                result
            }
        }
    }
}