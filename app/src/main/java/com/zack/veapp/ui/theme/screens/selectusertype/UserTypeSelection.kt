package com.zack.veapp.ui.theme.screens.selectusertype

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun UserTypeSelection(
onParentLogin: () -> Unit,
onDriverLogin: () -> Unit,
onAdminLogin: () -> Unit
) {
    val id = remember{ mutableStateOf(0) }
    Column {
        Text(text = "Select user type")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onParentLogin) {
            Text(text = "Parent")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onDriverLogin) {
            Text(text = "Driver")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onAdminLogin) {
            Text(text = "Admin")
        }
    }
}