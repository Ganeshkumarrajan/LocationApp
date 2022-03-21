package com.nordsec.locationapp.data.converter

import com.nordsec.locationapp.data.model.Location
import com.nordsec.locationapp.data.distance
import com.nordsec.locationapp.domain.model.LocationDomain
import com.nordsec.locationapp.domain.model.UserCurrentLocationDomain

fun Location.toDataToDomain(userLocation: UserCurrentLocationDomain?): LocationDomain =
    LocationDomain(
        this.city ?: "", this.latitude ?: 0.0F, this.longitude ?: 0.0F,
        distance(
            this.longitude?.toDouble() ?: 0.0, this.longitude?.toDouble() ?: 0.0,
            userLocation?.latitude?.toDouble()?:0.0, userLocation?.longitude?.toDouble()?:0.0
        )
    )