package com.nordsec.locationapp.di

import com.nordsec.locationapp.data.repository.LocationsRepository
import com.nordsec.locationapp.data.repository.LocationsRepositoryImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.dsl.module

val repositoryModule = module {
    single<LocationsRepository> {
        LocationsRepositoryImpl(get(), Schedulers.io(), AndroidSchedulers.mainThread())
    }
}