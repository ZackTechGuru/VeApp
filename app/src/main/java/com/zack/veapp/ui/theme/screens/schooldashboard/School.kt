package com.zack.veapp.ui.theme.screens.schooldashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen(viewModel: AdminViewModel) {
    val todaysPickups = viewModel.todaysPickups.value
    val availableDrivers = viewModel.availableDrivers.value
    val assignedRoutes = viewModel.assignedRoutes.value
    val trackedBus = viewModel.trackedBus.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "School Transportation Admin") }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TodaysPickupsList(todaysPickups)
            AvailableDriversList(availableDrivers)
            AssignedRoutesList(assignedRoutes)
            if (trackedBus != null) {
                TrackBus(trackedBus)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { viewModel.generateRoutes() }) {
                    Text(text = "Generate Routes")
                }
                Button(onClick = { viewModel.assignRoutes() }) {
                    Text(text = "Assign Routes")
                }
            }
        }
    }
}

@Composable
fun TodaysPickupsList(pickups: List<PickupData>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Todays Pickups:")
            pickups.forEach { pickup ->
                Text(text = "Child: ${pickup.name} - Location: ${pickup.coordinates}")
            }
        }
    }
}

@Composable
fun AvailableDriversList(drivers: List<DriverData>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Available Drivers:")
            drivers.forEach { driver ->
                Text(text = "Driver: ${driver.name}")
            }
        }
    }
}

@Composable
fun AssignedRoutesList(routes: List<AssignedRoute>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Assigned Routes:")
            routes.forEach { route ->
                Text(text = "Driver: ${route.driverName} - Route: ${route.routeDetails}")
            }
        }
    }
}


