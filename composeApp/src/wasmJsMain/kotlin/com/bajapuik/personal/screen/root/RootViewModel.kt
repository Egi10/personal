package com.bajapuik.personal.screen.root

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bajapuik.personal.domain.repository.ConfigurationRepository
import com.bajapuik.personal.screen.root.event.RootEvent
import kotlinx.coroutines.launch

class RootViewModel(
    private val configurationRepository: ConfigurationRepository
): ViewModel() {

    var isDarkMode by mutableStateOf(false)
        private set

    fun onEvent(event: RootEvent) {
        when (event) {
            is RootEvent.InitDartMode -> {
                getDarkMode(
                    default = event.default
                )
            }

            is RootEvent.SetDarkMode -> {
                isDarkMode = event.isDark
                setDarkMode(
                    isDark = event.isDark
                )
            }
        }
    }

    private fun setDarkMode(isDark: Boolean) {
        viewModelScope.launch {
            configurationRepository.setDarkMode(
                isDark = isDark
            )
        }
    }

    private fun getDarkMode(default: Boolean) {
        viewModelScope.launch {
            isDarkMode = configurationRepository.getDarkMode(
                default = default
            )
        }
    }
}