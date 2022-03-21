package com.nordsec.locationapp.di

import com.nordsec.locationapp.domain.usecase.LocationUseCase
import com.nordsec.locationapp.domain.usecase.LocationUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<LocationUseCase> {
        LocationUseCaseImpl(get())
    }
}
