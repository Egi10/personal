package com.bajapuik.personal.di

import com.bajapuik.personal.data.datasource.PersonalDataSource
import com.bajapuik.personal.data.datasource.PersonalDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<PersonalDataSource> {
        PersonalDataSourceImpl(
            httpClient = get()
        )
    }
}