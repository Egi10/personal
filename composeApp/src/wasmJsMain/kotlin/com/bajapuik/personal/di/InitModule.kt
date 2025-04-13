package com.bajapuik.personal.di

import org.koin.dsl.module

val initModule = module {
    includes(
        networkModule,
        dataSourceModule,
        repositoryModule,
        viewModelModule
    )
}