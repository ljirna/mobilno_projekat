package com.example.myapplication.screens.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserBottomBar (
    onHomeClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    BottomAppBar(
        containerColor = Color(0xffb36370),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onHomeClick) {
                Icon(painterResource(id = R.drawable.home), contentDescription = "", tint= Color.White)
            }
            IconButton(onClick = onSearchClick) {
                Icon(painterResource(id = R.drawable.search), contentDescription = "", tint = Color.White)
            }
            IconButton(onClick = onProfileClick) {
                Icon(painterResource(id = R.drawable.user1), contentDescription = "", tint =Color.White)
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun StudentBottomBarPreview() {
    UserBottomBar(
        onHomeClick = {},
        onSearchClick = {},
        onProfileClick = {}
    )
}