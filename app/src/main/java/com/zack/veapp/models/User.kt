package com.zack.veapp.models

class Child(
    val id: String,
    val name: String,
    val grade: Int
)
class Stop(
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val isPickUp: Boolean
)
class Route(
    val id: String,
    val date: String,
    val stops: List<Stop>
)
class Driver(
    val id: String,
    val name: String,
    val licenseNumber: String,
    val mobileNumber: Int
)