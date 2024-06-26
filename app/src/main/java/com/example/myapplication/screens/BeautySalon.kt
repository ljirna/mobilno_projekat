package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.model.SalonObject
import com.example.myapplication.model.Salons
import com.example.myapplication.model.Service
import com.example.myapplication.model.models.Users
import com.example.myapplication.screens.navigation.NavigationDestination
import com.example.myapplication.viewModel.AppViewModelProvider
import com.example.myapplication.viewModel.SalonFavoritesViewModel
import kotlinx.coroutines.launch

object BeautySalonDestination : NavigationDestination{
    override val route = "beautySalon"
    override val title = "Beauty Salon"
    const val userId = "userId"
    const val salonId = "salonId"
    val routeWithArgs = "$route/{$userId}/{$salonId}"
}

/*
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SalonWithBottomBar(
    navigateToHome: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToProfile: () -> Unit,
) {
    Scaffold(
        //bottomBar = { UserBottomBar(onHomeClick = navigateToHome, onSearchClick = navigateToSearch, onProfileClick = navigateToProfile) }
    ) {
        Home()
    }
}
*/
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BeautySalon(
    salonId: Int,
    userId:Int,
    modifier: Modifier = Modifier,
    viewModel: SalonFavoritesViewModel = viewModel(factory = AppViewModelProvider.Factory),
    navigateToHomePage: () -> Unit
    //,navigateToSearch: () -> Unit,
    //navigateToProfile: () -> Unit
){
    var salon = SalonObject.salons.find { it.id == salonId } ?: return
    var isFavorite by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(salon.id, userId) {
        viewModel.isFavourite(salon.id, userId) { result ->
            isFavorite = result
        }
    }


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0XF3F3F3F3))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp) // Adjust height as needed
                .background(color = Color(0xffb36370))
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {

                IconButton(onClick = { /*TODO*/ }, Modifier
                    .size(48.dp)
                    .offset(y = 8.dp)) {
                    Icon(painter = painterResource(id = R.drawable.back), contentDescription = "", tint = Color.White, modifier = Modifier
                        .size(25.dp)
                        .offset(x = -8.dp))
                }


                Text(
                    text = "Beauty Salon",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .weight(1f) // This will make the Text composable take up as much space as it can
                        .padding(20.dp)
                        .offset(x = 16.dp)
                )

                IconButton(onClick = { /*TODO*/ },
                    Modifier
                        .size(48.dp)
                        .offset(y = 8.dp)) { // Increase the size here
                    Icon(painter = painterResource(id = R.drawable.user), contentDescription = "", tint = Color.White, modifier = Modifier
                        .size(25.dp)
                        .offset(x = -8.dp)) // And here
                }
            }
        }
        Image(
            painter = painterResource(id = salon.image),
            contentDescription = "Rectangle 1",
            modifier = modifier
                .requiredHeight(height = 144.dp)
                .width(390.dp)
        )
        Row (verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = salon.title,
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp)
            )
            IconButton(onClick = {
                isFavorite = !isFavorite
                coroutineScope.launch {
                    if (isFavorite) {
                        viewModel.insertFavorite(salon.id, userId)
                    } else {
                        viewModel.deleteFavorite(salon.id, userId)
                    }
                }
            }) {
                Icon(
                    painter = painterResource(id = if (isFavorite) R.drawable.favorite else R.drawable.reacted_favorite_24),
                    contentDescription = "outline / favorite",
                    tint = Color(0xffb36370),
                    modifier = Modifier
                        .padding(24.dp)
                        .requiredSize(size = 24.dp)
                )
            }

        }
        Column (modifier = Modifier.padding(start =16.dp) ){
            Row {
                Icon(painter =painterResource(id = R.drawable.location), contentDescription ="Location")
                Text (
                    text = salon.address,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "outline / star-1",
                    tint = Color(0xffffb300),
                    modifier = Modifier.requiredSize(size = 24.dp)
                )
                Text(
                    text = salon.grade,
                    color = Color.Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier.padding(start = 4.dp) // Small padding to the start of the text
                )
            }
        }
        Box (modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp),
            contentAlignment = Alignment.Center) {

            LazyColumn(modifier = Modifier.offset(y =20.dp) ){
                items(salon.listOfServices) {
                        service ->
                    ServiceCard(service = service)
                }
            }
        }

    }
}





@Composable
fun ServiceCard (service: Service, modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier.padding(8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(all = 8.dp)
                .requiredWidth(width = 342.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color.White)

        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = service.title,
                    color = Color.Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .drawWithCache {
                        val borderWidth = 2.dp.toPx()
                        onDrawWithContent {
                            drawContent()
                            drawRect(
                                color = Color.Black,
                                topLeft = Offset(0f, 0f),
                                size = Size(borderWidth, size.height)
                            )
                        }
                    }
                    .height(40.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                    modifier = Modifier
                        .padding(horizontal = 8.dp,
                            vertical = 4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = service.price,
                            color = Color.Black,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 14.sp
                            )
                        )
                        Text(
                            text = " KM",
                            color = Color.Black,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun BeautySalonPreview() {
    val salon = SalonObject.salons.find { it.id == 1 } ?: return
    //BeautySalon(salonId, userId)
}