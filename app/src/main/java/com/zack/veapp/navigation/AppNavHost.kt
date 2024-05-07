package com.zack.veapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zack.veapp.ui.theme.screens.driverdashboard.Driver
import com.zack.veapp.ui.theme.screens.home.Home
import com.zack.veapp.ui.theme.screens.login.Login
import com.zack.veapp.ui.theme.screens.parentdashboard.Parent
import com.zack.veapp.ui.theme.screens.registration.Registration
import com.zack.veapp.ui.theme.screens.schooldashboard.School
import com.zack.veapp.ui.theme.screens.splash.Splash
import java.security.AccessController

@Composable
fun AppNavHost(modifier: Modifier= Modifier, navController: NavHostController= rememberNavController(),startDestination: String= ROUTE_SPLASH) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            Login(navController)
        }
        composable(ROUTE_REGISTER) {
            Registration(navController)
        }
        composable(ROUTE_SPLASH) {
            Splash(navController)
        }
        composable(ROUTE_HOME){
            Home(navController)
        }
        composable(ROUTE_PARENT){
            Parent(navController)
        }
        composable(ROUTE_SCHOOL){
            School(navController)
        }
        composable(ROUTE_DRIVER){
            Driver(navController)
        }

    }
}