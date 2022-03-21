package com.nordsec.locationapp.presentation.model

import com.nordsec.locationapp.domain.model.LocationDomain

sealed class UIState<in T> {
    data class Success<T>(val t: T) : UIState<T>()
    data class Error<T>(val message: String) : UIState<T>()
    class Loading<T>: UIState<T>()
}

data class LocationUIData(val city: String)

fun LocationDomain.domainToUI():LocationUIData =
    LocationUIData(this.city)