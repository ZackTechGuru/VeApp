package com.zack.veapp.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zack.veapp.R
import com.zack.veapp.navigation.ROUTE_DRIVER
import com.zack.veapp.navigation.ROUTE_PARENT
import com.zack.veapp.navigation.ROUTE_REGISTER
import com.zack.veapp.navigation.ROUTE_SCHOOL
import com.zack.veapp.ui.theme.BrightYellow
import com.zack.veapp.ui.theme.Greyblue
import com.zack.veapp.ui.theme.Purple
import com.zack.veapp.ui.theme.SecondaryBlue
import com.zack.veapp.ui.theme.screens.selectusertype.UserTypeSelection

@Composable
fun Login(navController:NavHostController) {
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var context= LocalContext.current
    val isChecked = remember { mutableStateOf(false) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Greyblue)
    ){
        Box {
            Image(painter = painterResource(id = R.drawable.splash), contentDescription = "")
        }
        Text(
            text = "Welcome Back,",
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = SecondaryBlue
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Login to continue!",
            fontFamily = FontFamily.SansSerif,
            fontSize = 12.sp,
            color = SecondaryBlue
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text(text = "Enter email", color = Color.White)},
            shape = RoundedCornerShape(25.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color. White,
                unfocusedBorderColor = Color.White,
                unfocusedLeadingIconColor = SecondaryBlue)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Enter password", color = Color.White)},
            shape = RoundedCornerShape(25.dp),
            leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "password")},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                unfocusedLeadingIconColor = SecondaryBlue
            )
            )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = SecondaryBlue),
            modifier = Modifier.size(width = 250.dp, height = 35.dp)
        ) {
            Text(text = " Login", fontSize = 15.sp, color = Greyblue)}
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween) {

            UserTypeSelection(
                onParentLogin = { navController.navigate(ROUTE_PARENT)},
                onDriverLogin = { navController.navigate(ROUTE_DRIVER)},
                onAdminLogin = { navController.navigate(ROUTE_SCHOOL)}
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "New User?", fontSize = 15.sp, color = SecondaryBlue)
        TextButton(onClick = {navController.navigate(ROUTE_REGISTER)},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Unspecified) ,
            modifier = Modifier.size(width = 250.dp, height = 35.dp)
            ) {
            Text(text = "Signup.",
                fontSize = 15.sp,
                color = SecondaryBlue)

        }
    }
}

@Preview
@Composable
private fun LoginPre() {
    Login(rememberNavController())

}