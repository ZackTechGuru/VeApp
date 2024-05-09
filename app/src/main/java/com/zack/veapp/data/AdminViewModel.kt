package com.zack.veapp.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.internal.NopCollector.emit

class AdminViewModel(private val repository: SchoolTransportRepository) : ViewModel() {

    val presentDrivers = liveData { emit(repository.getPresentDrivers()) }
    val generatedRoutes = liveData { emit(repository.getGeneratedRoutes()) }
    val selectedDriver = mutableStateOf<Driver?>(null)
    val selectedRoute = mutableStateOf<Route?>(null)

    fun onDriverSelected(driver: Driver) {
        selectedDriver.value = driver
    }

    fun onRouteSelected(route: Route) {
        selectedRoute.value = route
    }

    fun onAssignRoute(driver: Driver, route: Route) {
        repository.assignRoute(driver, route)
    }
}

interface SchoolTransportRepository {
    fun getPresentDrivers(): List<Driver>
    fun getGeneratedRoutes(): List<Route>
    fun assignRoute(driver: Driver, route: Route)
}

data class Driver(val id: String, val name: String)
data class Route(val id: String, val name: String, val description: String)
