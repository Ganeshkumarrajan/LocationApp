package com.nordsec.locationapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.nordsec.locationapp.domain.model.LocationSortType
import com.nordsec.locationapp.domain.model.LocationsDomain
import com.nordsec.locationapp.domain.model.UserCurrentLocationDomain
import com.nordsec.locationapp.domain.usecase.LocationUseCase
import com.nordsec.locationapp.presentation.model.LocationUIData
import com.nordsec.locationapp.presentation.model.UIState
import com.nordsec.locationapp.presentation.model.domainToUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/*
*
* MainViewModel to fetch repository data and display for view
*
*/
class MainViewModel(private val useCase: LocationUseCase) : ViewModel() {

    private val _locationState = MutableStateFlow<UIState<List<LocationUIData>>>(UIState.Loading())
    val locationState: StateFlow<UIState<List<LocationUIData>>> = _locationState

    fun getLocationsSortedByDistance() = getLocations(LocationSortType.SORT_BY_LOCATION)

    fun getLocationsSortedByCityName() = getLocations(LocationSortType.SORT_BY_CITY)

    private fun getLocations(sortType: LocationSortType) {
        useCase.getLocation(sortType = sortType, getUserLocation()).subscribe(
            {
                onSuccess(it)
            }, {
                onError(it)
            }
        )
    }

    private fun onSuccess(data: LocationsDomain) {
        _locationState.value = UIState.Success(data.location.map {
            it.domainToUI()
        })
    }

    private fun onError(throwable: Throwable) {
        _locationState.value = UIState.Error(throwable.localizedMessage ?: "")
    }

    private fun getUserLocation(): UserCurrentLocationDomain =
        UserCurrentLocationDomain(30.3321838F, -81.65565099999999F)

}
