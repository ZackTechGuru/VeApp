package com.zack.veapp.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.internal.NopCollector.emit

class HomeViewModel(private val repository: SchoolTransportRepository) : ViewModel() {

    val childName = liveData { emit(repository.getChildName()) }
    val childGrade = liveData { emit(repository.getChildGrade()) }
    val driverName = liveData { emit(repository.getDriverName()) }
    val driverRating = liveData { emit(repository.getDriverRating()) }
    val estimatedArrivalTime = liveData { emit(repository.getEstimatedArrivalTime()) }
    val recentActivity = liveData { emit(repository.getRecentActivity()) }
    val alertMessage = liveData { emit(repository.getAlertMessage()) }

    fun setPickupLocation(latitude: Double, longitude: Double) {
        repository.setPickupLocation(latitude, longitude)
    }
}

interface SchoolTransportRepository {
    fun getChildName(): String
    fun getChildGrade(): Int
    fun getDriverName(): String
    fun getDriverRating(): Float
    fun getEstimatedArrivalTime(): String
    fun getRecentActivity(): List<String>
    fun getAlertMessage(): String?
    fun setPickupLocation(latitude: Double, longitude: Double)
}
