package com.nordsec.locationapp.domain.model

data class LocationDomain(
    val city: String,
    val latitude: Float,
    val longitude: Float,
    val distance: Double
)

data class LocationsDomain(val location: List<LocationDomain>)


