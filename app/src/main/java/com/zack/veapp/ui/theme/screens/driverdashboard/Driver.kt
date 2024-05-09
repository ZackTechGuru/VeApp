package com.zack.veapp.ui.theme.screens.driverdashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DriverHomeScreen(viewModel: DriverViewModel) {
    val driverName = viewModel.driverName.value
    val isPresent = viewModel.isPresent.value
    val assignedRoute = viewModel.assignedRoute.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Welcome, $driverName") }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            DriverStatusCard(
                isPresent = isPresent,
                onStatusChange = { viewModel.onPresenceChange(it) }
            )
            if (isPresent) {
                AssignedRouteCard(assignedRoute)
                DriverActions(
                    onBreakdownAlert = { viewModel.onBreakdownAlert() },
                    onChildPicked = { viewModel.onChildPicked() },
                    onChildAlighted = { viewModel.onChildAlighted() }
                )
            }
        }
    }
}

@Composable
fun DriverStatusCard(
    isPresent: Boolean,
    onStatusChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Are you present today?")
            Switch(
                checked = isPresent,
                onCheckedChange = onStatusChange
            )
        }
    }
}

@Composable
fun AssignedRouteCard(assignedRoute: String) {
    if (assignedRoute.isNotEmpty()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Assigned Route:")
                Text(text = assignedRoute)
            }
        }
    }
}

@Composable
fun DriverActions(
    onBreakdownAlert: () -> Unit,
    onChildPicked: () -> Unit,
    onChildAlighted: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
        Button(onClick = onBreakdownAlert) {
            Text(text = "Report Vehicle Breakdown")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onChildPicked) {
            Text(text = "Child Picked Up")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onChildAlighted) {
            Text(text = "Child Arrived at School")
        }
    }
}

@Preview
@Composable
private fun DriverHomeScreenPrev() {
    DriverHomeScreen(rememberNavController())

}