package com.nordsec.locationapp.di

import com.nordsec.locationapp.data.repository.LocationsRepository
import com.nordsec.locationapp.data.repository.LocationsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LocationsRepository> {
        LocationsRepositoryImpl(get())
    }
}