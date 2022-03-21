package com.nordsec.locationapp.domain.usecase

import com.nordsec.locationapp.domain.model.LocationSortType
import com.nordsec.locationapp.domain.model.LocationsDomain
import com.nordsec.locationapp.domain.model.UserCurrentLocationDomain
import io.reactivex.rxjava3.core.Observable

interface LocationUseCase {
    fun getLocation(
        sortType: LocationSortType,
        userCurrentLocationDomain: UserCurrentLocationDomain
    ): Observable<LocationsDomain>
}
