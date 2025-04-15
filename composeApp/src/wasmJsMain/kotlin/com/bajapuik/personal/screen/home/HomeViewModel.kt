package com.bajapuik.personal.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bajapuik.personal.domain.model.Experience
import com.bajapuik.personal.domain.model.Testimonial
import com.bajapuik.personal.domain.model.Work
import com.bajapuik.personal.domain.repository.PersonalRepository
import com.bajapuik.personal.screen.home.event.HomeEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val personalRepository: PersonalRepository
): ViewModel() {

    private val _testimonialsUiState = MutableStateFlow<List<Testimonial>>(emptyList())
    val testimonialsUiState get() =  _testimonialsUiState.asStateFlow()

    private val _worksUiState = MutableStateFlow<List<Work>>(emptyList())
    val worksUiState get() =  _worksUiState.asStateFlow()

    private val _experiencesUiState = MutableStateFlow<List<Experience>>(emptyList())
    val experiencesUiState get() =  _experiencesUiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Init -> {
                getTestimonials()
                getWorks()
                getExperiences()
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
}