package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.screens.navigation.NavigationDestination

object SplashDestination : NavigationDestination {
    override val route: String = "splash"
    override val title: String = "Splash"
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToLogin: () -> Unit  = {}) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "", modifier = Modifier.size(140.dp))
        Text(text ="Welcome to GlamifyMe", modifier = Modifier.offset(y = 20.dp), fontSize = 20.sp)
        Text(text = "Unlock Your True Glow", modifier = Modifier.offset(y = 30.dp), fontSize = 16.sp, color = Color.Gray)
    }
    Row(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom){
        IconButton(onClick = { navigateToLogin()}, modifier = Modifier.size(70.dp)) {
            Icon(painter = painterResource(id = R.drawable.next), contentDescription = "", modifier = Modifier.size(50.dp), tint = Color(0xffb36370))
        }
    }
}

@Preview
@Composable
public fun SplashScreenPreview() {
    SplashScreen(Modifier)
}