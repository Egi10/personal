package com.bajapuik.personal.di

import com.bajapuik.personal.data.repository.PersonalRepositoryImpl
import com.bajapuik.personal.domain.repository.PersonalRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PersonalRepository> {
        PersonalRepositoryImpl(
            personalDataSource = get()
        )
    }
}