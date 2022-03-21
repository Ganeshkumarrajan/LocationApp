package com.nordsec.locationapp.data.dataSource

import com.nordsec.locationapp.data.model.Locations
import io.reactivex.rxjava3.core.Observable

interface LocationDataSource{
    fun getLocation(): Observable<Locations>
}