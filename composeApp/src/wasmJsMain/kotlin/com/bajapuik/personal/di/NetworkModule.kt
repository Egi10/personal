package com.bajapuik.personal.di

import com.bajapuik.personal.core.network.HttpClientFactory
import com.bajapuik.personal.core.network.JsonFactory
import org.koin.dsl.module

val networkModule = module {
    single {
        JsonFactory.create()
    }

    single {
        HttpClientFactory.create(
            json = get(),
            baseUrl = "egi10.github.io",
            path = "data/"
        )
    }
}