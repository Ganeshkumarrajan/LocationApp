package com.nordsec.locationapp

import com.nordsec.locationapp.domain.model.LocationDomain
import com.nordsec.locationapp.domain.model.LocationsDomain
import com.nordsec.locationapp.domain.model.UserCurrentLocationDomain

fun getLocations(): LocationsDomain =
    LocationsDomain(
        listOf(LocationDomain("city", 1.22F, 3.55F, 30.0))
    )

 fun getUserLocation(): UserCurrentLocationDomain =
    UserCurrentLocationDomain(30.3321838F, -81.65565099999999F)