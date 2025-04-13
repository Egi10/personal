package com.bajapuik.personal.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bajapuik.personal.domain.model.Testimonial
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

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Init -> {
                getTestimonials()
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
}