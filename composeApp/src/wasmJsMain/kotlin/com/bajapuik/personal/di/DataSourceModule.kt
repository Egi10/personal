package com.bajapuik.personal.di

import com.bajapuik.personal.data.source.PersonalDataSource
import com.bajapuik.personal.data.source.PersonalDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<PersonalDataSource> {
        PersonalDataSourceImpl(
            httpClient = get()
        )
    }
}