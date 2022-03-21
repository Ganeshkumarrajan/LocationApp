package com.nordsec.locationapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nordsec.locationapp.domain.model.LocationSortType
import com.nordsec.locationapp.domain.usecase.LocationUseCase
import com.nordsec.locationapp.presentation.model.UIState
import com.nordsec.locationapp.presentation.viewmodel.MainViewModel
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class MainViewModelTest {
    @get:Rule
    val testRule = InstantTaskExecutorRule()
    private val locationUseCase: LocationUseCase = mock(LocationUseCase::class.java)
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel(locationUseCase)
    }

    @Test
    fun `get location by city success`() {
        //given
        val data =
            `when`(
                locationUseCase.getLocation(
                    LocationSortType.SORT_BY_CITY,
                    getUserLocation()
                )
            ).thenReturn(Observable.just(getLocations()))
        //when
        viewModel.getLocationsSortedByCityName()
        //then
        assert(viewModel.locationState.value is UIState.Success)
    }

    @Test
    fun `get location by city error`() {
        //given
        `when`(
            locationUseCase.getLocation(
                LocationSortType.SORT_BY_CITY,
                getUserLocation()
            )
        ).thenReturn(Observable.error(Throwable()))

        viewModel.getLocationsSortedByCityName()
        assert(viewModel.locationState.value is UIState.Error)
    }


}