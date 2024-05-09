package com.zack.veapp.ui.theme.screens.parentdashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: NavHostController) {
    val childName = viewModel.childName.value
    val childGrade = viewModel.childGrade.value
    val driverName = viewModel.driverName.value
    val driverRating = viewModel.driverRating.value
    val estimatedArrivalTime = viewModel.estimatedArrivalTime.value
    val recentActivity = viewModel.recentActivity.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "$childName (Grade $childGrade)") },
                navigationIcon = {
                    IconButton(onClick = { /* navigate to profile screen */ }) {
                        // Icon for profile picture (optional)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TodayPickupCard(
                onSetLocationClick = { /* navigate to set location screen */ },
                driverName = driverName,
                driverRating = driverRating,
                estimatedArrivalTime = estimatedArrivalTime,
                onMapClick = { /* open full map view */ },
                alertMessage = viewModel.alertMessage.value
            )
            RecentActivity(recentActivity)
        }
    }
}

@Composable
fun TodayPickupCard(
    onSetLocationClick: () -> Unit,
    driverName: String,
    driverRating: Float,
    estimatedArrivalTime: String,
    onMapClick: () -> Unit,
    alertMessage: String?
) {
    Card(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column(modifier = Modifier
            .padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth()
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onSetLocationClick) {
                    Text(text = "Set Pickup Location")
                }
                Text(text = "Driver: $driverName ($driverRating)")
            }
            Row {
                Text(text = "Estimated Arrival Time:")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = estimatedArrivalTime)
            }
            Row(modifier = Modifier
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onMapClick) {
                    Icon(Icons.Map) // Material icon for map
                }
                if (alertMessage != null) {
                    Text(
                        text = "alertMessage",
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
@Composable
fun RecentActivity(recentActivity: List<String>) {
    if (recentActivity.isNotEmpty()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Column(modifier = Modifier
                .padding(16.dp)) {
                Text(text = "Recent Activity")

            Spacer(modifier = Modifier
                .height(8.dp))

                recentActivity.forEach { message ->
                    Text(text = message)
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPre() {
    HomeScreen(rememberNavController())

}