package com.nordsec.locationapp.presentation.componenet

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nordsec.locationapp.presentation.LocationScreen


sealed class LocationScreen(val route: String) {
    object ListScreen : LocationScreen("list_screen")
}

@Composable
fun LocationAppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LocationScreen.ListScreen.route
    ) {

        composable(route = LocationScreen.ListScreen.route) {
            GoToListScreen(navController)
        }

    }
}

@Composable
private fun GoToListScreen(navController: NavController) {
    LocationScreen()
}



private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED