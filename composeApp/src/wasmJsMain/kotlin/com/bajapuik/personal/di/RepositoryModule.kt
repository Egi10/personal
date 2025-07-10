package com.bajapuik.personal.di

import com.bajapuik.personal.data.repository.configuration.ConfigurationRepositoryImpl
import com.bajapuik.personal.data.repository.personal.PersonalRepositoryImpl
import com.bajapuik.personal.domain.repository.ConfigurationRepository
import com.bajapuik.personal.domain.repository.PersonalRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PersonalRepository> {
        PersonalRepositoryImpl(
            personalRemoteDataSource = get()
        )
    }

    single<ConfigurationRepository> {
        ConfigurationRepositoryImpl(
            personalLocalDataSource = get()
        )
    }
}