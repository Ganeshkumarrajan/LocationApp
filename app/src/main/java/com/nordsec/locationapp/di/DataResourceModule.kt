package com.nordsec.locationapp.di

import com.nordsec.locationapp.data.dataSource.LocationDataSource
import com.nordsec.locationapp.data.dataSource.LocationDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DataResourceModule = module {
    single<LocationDataSource> {
        LocationDataSourceImpl(androidContext())
    }
}