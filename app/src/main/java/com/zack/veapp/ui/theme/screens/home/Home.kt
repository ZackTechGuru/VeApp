package com.zack.veapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zack.veapp.ui.theme.PrimaryGrey

@Composable
fun Home(navController: NavHostController) {
Column (
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxSize()
        .background(color = PrimaryGrey)
){


}

}

@Preview
@Composable
private fun HomePrev() {
    Home(rememberNavController())

}