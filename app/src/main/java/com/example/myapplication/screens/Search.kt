package com.example.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.SalonObject
import com.example.myapplication.screens.navigation.NavigationDestination

object SearchDestination : NavigationDestination {
    override val route = "search"
    override val title = "Search"
}
/*
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SearchWithBottomBar(
    navigateToHome: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToProfile: () -> Unit,
) {
    Scaffold(
        //bottomBar = { UserBottomBar(onHomeClick = navigateToHome, onSearchClick = navigateToSearch, onProfileClick = navigateToProfile) }
    ) {
        Home()
    }
}*/
@Composable
fun Search(modifier: Modifier = Modifier,
          navigateToHomePage: () -> Unit = {},
          navigateToBeautySalon: () -> Unit = {},
          navigateToProfile: () -> Unit = {}
) {
    Column(modifier = Modifier
        .background(color = Color(0XF3F3F3F3))
        .width(390.dp)
        .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp) // Adjust height as needed
                .background(color = Color(0xffb36370))
        ) {
            Heading("Search", Modifier);
        }

        LazyColumn(modifier = Modifier.offset(y =10.dp) ){
            items(SalonObject.salons) {
                    salons->
                SalonsCard(salons = salons)
            }
        }
    }

}

@Preview
@Composable
fun SearchPreview(){
    Search()
}