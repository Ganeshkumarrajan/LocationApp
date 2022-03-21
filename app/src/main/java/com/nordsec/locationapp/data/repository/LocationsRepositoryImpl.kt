package com.nordsec.locationapp.data.repository

import com.nordsec.locationapp.data.model.Locations
import com.nordsec.locationapp.data.dataSource.LocationDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LocationsRepositoryImpl(
    private val locationDataSource: LocationDataSource,
    private val processScheduler: Scheduler,
    private val androidScheduler: Scheduler
) :
    LocationsRepository {
    override fun getLocation(): Observable<Locations> =
        locationDataSource.getLocation().subscribeOn(processScheduler)
            .observeOn(androidScheduler)
}
