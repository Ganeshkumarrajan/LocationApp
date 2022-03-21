package com.nordsec.locationapp.domain.usecase

import com.nordsec.locationapp.data.converter.toDataToDomain
import com.nordsec.locationapp.data.model.Location
import com.nordsec.locationapp.data.repository.LocationsRepository
import com.nordsec.locationapp.domain.model.UserCurrentLocationDomain
import com.nordsec.locationapp.domain.model.LocationDomain
import com.nordsec.locationapp.domain.model.LocationSortType
import com.nordsec.locationapp.domain.model.LocationsDomain
import io.reactivex.rxjava3.core.Observable


class LocationUseCaseImpl(private val repository: LocationsRepository) : LocationUseCase {
    private var sortType: LocationSortType? = null
    private var userCurrentLocationDomain: UserCurrentLocationDomain? = null

    override fun getLocation(
        sortType: LocationSortType,
        userCurrentLocationDomain: UserCurrentLocationDomain
    ): Observable<LocationsDomain> {
        this.sortType = sortType
        this.userCurrentLocationDomain = userCurrentLocationDomain

        return repository.getLocation().map {
            LocationsDomain(sortLocation(it.location))
        }
    }

    private fun sortLocation(locations: List<Location>): List<LocationDomain> {
        val domainLocations = locations.map {
            it.toDataToDomain(userCurrentLocationDomain)
        }
        return when (sortType) {
            LocationSortType.SORT_BY_LOCATION -> sortByDistance(domainLocations)
            LocationSortType.SORT_BY_CITY -> sorByCityName(domainLocations)
            else -> sorByCityName(domainLocations)
        }
    }

    private fun sortByDistance(data: List<LocationDomain>): List<LocationDomain> =
        data.sortedBy {
            it.distance
        }


    private fun sorByCityName(data: List<LocationDomain>): List<LocationDomain> =
        data.sortedBy {
            it.city
        }

}
