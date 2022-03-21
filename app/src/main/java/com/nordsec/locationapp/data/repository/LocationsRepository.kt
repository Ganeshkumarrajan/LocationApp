package com.nordsec.locationapp.data.repository

import com.nordsec.locationapp.data.model.Locations
import io.reactivex.rxjava3.core.Observable

interface LocationsRepository {
    fun getLocation(): Observable<Locations>
}
