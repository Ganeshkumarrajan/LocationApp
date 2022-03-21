package com.nordsec.locationapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.nordsec.locationapp.presentation.componenet.LocationAppNavigation
import com.nordsec.locationapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getLocationsSortedByDistance()

        setContent {
            MaterialTheme {
                LocationAppNavigation()
            }
        }
    }
}
