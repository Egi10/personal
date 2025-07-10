package com.bajapuik.personal.di

import com.bajapuik.personal.screen.home.HomeViewModel
import com.bajapuik.personal.screen.root.RootViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::RootViewModel)
}