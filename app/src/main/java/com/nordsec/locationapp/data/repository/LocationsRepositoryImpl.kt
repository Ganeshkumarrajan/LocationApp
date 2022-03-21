package com.nordsec.locationapp.data.repository

import com.nordsec.locationapp.data.model.Locations
import com.nordsec.locationapp.data.dataSource.LocationDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


class LocationsRepositoryImpl(private val locationDataSource: LocationDataSource) :
    LocationsRepository {
    override fun getLocation(): Observable<Locations> =
        locationDataSource.getLocation().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
