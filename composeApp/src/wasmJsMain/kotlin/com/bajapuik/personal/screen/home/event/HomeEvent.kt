package com.bajapuik.personal.screen.home.event

sealed class HomeEvent {
    data object Init : HomeEvent()
}