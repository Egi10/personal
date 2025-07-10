package com.bajapuik.personal.di

import com.bajapuik.personal.data.source.local.PersonalLocalDataSource
import com.bajapuik.personal.data.source.local.PersonalLocalDataSourceImpl
import com.bajapuik.personal.data.source.remote.PersonalRemoteDataSource
import com.bajapuik.personal.data.source.remote.PersonalRemoteDataSourceImpl
import com.russhwolf.settings.StorageSettings
import org.koin.dsl.module

val dataSourceModule = module {
    single<PersonalRemoteDataSource> {
        PersonalRemoteDataSourceImpl(
            httpClient = get()
        )
    }

    single<PersonalLocalDataSource> {
        PersonalLocalDataSourceImpl(
            settings = StorageSettings()
        )
    }

}