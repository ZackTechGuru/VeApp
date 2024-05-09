package com.zack.veapp.data

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.internal.NopCollector.emit

class DriverViewModel(private val repository: SchoolTransportRepository) : ViewModel() {

    val driverName = liveData { emit(repository.getDriverName()) }
    val isPresent = mutableStateOf(false)
    val assignedRoute = liveData { emit(repository.getAssignedRoute(driverName.value!!)) }

    fun onPresenceChange(isPresent: Boolean) {
        this.isPresent.value = isPresent
        repository.setDriverPresence(isPresent)
    }

    fun onBreakdownAlert() {
        repository.sendBreakdownAlert(driverName.value!!)
    }

    fun onChildPicked() {
        repository.childPickedUp(driverName.value!!, assignedRoute.value!!)
    }

    fun onChildAlighted() {
        repository.childArrivedAtSchool(driverName.value!!, assignedRoute.value!!)
    }
}

interface SchoolTransportRepository {
    fun getDriverName(): String
    fun getAssignedRoute(driverName: String): String
    fun setDriverPresence(isPresent: Boolean)
    fun sendBreakdownAlert(driverName: String)
    fun childPickedUp(driverName: String, route: String)
    fun childArrivedAtSchool(driverName: String, route: String)
}
