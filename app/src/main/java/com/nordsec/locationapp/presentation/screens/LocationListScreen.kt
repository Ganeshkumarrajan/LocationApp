package com.nordsec.locationapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nordsec.locationapp.presentation.model.LocationUIData
import com.nordsec.locationapp.presentation.model.UIState
import com.nordsec.locationapp.presentation.viewmodel.MainViewModel
import dev.burnoo.cokoin.viewmodel.getViewModel

@Composable
fun LocationScreen(viewModel: MainViewModel = getViewModel()) {
    getItems(viewModel = viewModel)
    viewModel.getLocationsSortedByCityName()
}

@Composable
fun getItems(viewModel: MainViewModel) {
    when (val state = viewModel.locationState.collectAsState().value) {
        is UIState.Success -> {
            showItems(state.t)
        }
    }
}

@Composable
fun showItems(locationItems: List<LocationUIData>) {

    LazyColumn() {
        items(locationItems) { location ->
            Text(location.city, modifier = Modifier.padding(15.dp))
        }
    }

}
