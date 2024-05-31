package com.example.myapplication.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.myapplication.R


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BeautySalon(modifier: Modifier = Modifier){
    var isFavorite by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxWidth(). background(color = Color(0XF3F3F3F3))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp) // Adjust height as needed
                .background(color = Color(0xffb36370))
        ) {
            Heading("Beauty Salon", Modifier);
        }
        Image(
            painter = painterResource(id = R.drawable.salon),
            contentDescription = "Rectangle 1",
            modifier = modifier
                .requiredHeight(height = 144.dp)
                .width(390.dp)
        )
        Row (verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Desert Spring",
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp)
            )
            Icon(
                painter = painterResource(id = if (isFavorite) R.drawable.reacted_favorite_24 else R.drawable.favorite),
                contentDescription = "outline / favorite",
                tint = Color(0xffb36370),
                modifier = Modifier
                    .padding(24.dp)
                    .requiredSize(size = 24.dp)
                    .clickable {
                        isFavorite = !isFavorite
                    }
            )
        }
        Column (modifier = Modifier.padding(start =16.dp) ){
            Row {
                Icon(painter =painterResource(id = R.drawable.location), contentDescription ="Location")
                Text (
                    text = "Rustem-pašina 23, II sprat, 71000 Sarajevo",
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
                    text = "4.5",
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

            Column (modifier = Modifier.offset(y = 4.dp)) {
                card(service = "Hair Color", price = 300)
                card(service = "Perm", price = 500 )
                card(service = "Styling", price = 100)
            }
        }

    }
}


@Composable
fun Heading(title: String, modifier: Modifier = Modifier) {
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Text(
            text = "$title",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Composable
fun card (service: String, price: Int, modifier: Modifier = Modifier) {
    Row (modifier = Modifier.padding(12.dp)){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .requiredWidth(width = 342.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color.White)
                .padding(all = 4.dp)


        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "$service",
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
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start)
                    ) {
                        Text(
                            text = "$price" + " KM",
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
    BeautySalon(Modifier);
}