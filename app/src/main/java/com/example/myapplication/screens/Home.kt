package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.Categories
import com.example.myapplication.model.CategoriesObject
import com.example.myapplication.model.SalonObject
import com.example.myapplication.model.Salons
//import com.example.myapplication.screens.navigation.UserBottomBar



@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun HomeWithBottomBar(
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

@Composable
fun Home(//navigateToSearch: () -> Unit,
    //navigateToProfile: () -> Unit
) {

    // State to keep track of the selected category
    var selectedCategory by remember { mutableStateOf<Categories?>(null) }

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
                .clickable {
                    // Clear the selected category when the header is clicked
                    selectedCategory = null
                }
        ) {
            Heading("Home", Modifier)
        }
        ScrollCategory(onCategoryClick = { category ->
            selectedCategory = category
        })

        val filteredSalons = if (selectedCategory == null) {
            SalonObject.salons
        } else {
            SalonObject.salons.filter { it.id == selectedCategory?.id }
        }


        LazyColumn(modifier = Modifier.offset(y =20.dp) ){
            items(filteredSalons) {
                    salon ->
                SalonsCard(salons = salon)
            }
        }

    }
}

@Composable
fun ScrollCategory(onCategoryClick: (Categories) -> Unit){
    LazyRow (modifier = Modifier
        .fillMaxWidth()
        .size(140.dp)
        .offset(y = 20.dp)
        .padding(all = 1.dp)

    ) {
        items(CategoriesObject.categories) { category ->
            CategoryCard(category = category, onClick = {
                onCategoryClick(category)
            })
        }
    }


}




@Composable
fun CategoryCard(category: Categories, onClick: () -> Unit) {
    Column (modifier = Modifier
        .clickable { onClick() }
        .offset(x = 25.dp, y = 8.dp)
        .padding(end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = category.image),
            contentDescription = "",
            modifier = Modifier
                .requiredSize(size = 90.dp)
                .clip(CircleShape)
        )
        Row (Modifier.offset(y = 13.dp)) {
            Text(
                text =category.title,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp
                ),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun SalonsCard (salons: Salons){ //, navController: NavController

    Column (
        modifier = Modifier
            .offset(y = 15.dp)
            .padding(25.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .shadow(10.dp)
            .background(Color.White)
    )
    {

        Image(
            painter = painterResource(id = salons.image),
            contentDescription = "Rectangle 1",
            modifier = Modifier
                .requiredHeight(height = 126.dp)
                .fillMaxWidth()
                .fillMaxHeight()

        )
        Row  {
            Text(
                text = salons.title,
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(19.dp)
            )

            Row(
                modifier = Modifier.padding(19.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "outline / star-1",
                    tint = Color(0xffffb300),
                    modifier = Modifier.requiredSize(size = 24.dp)
                )
                Text(
                    text = salons.grade,
                    color = Color.Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                    ),
                    modifier = Modifier.padding(start = 4.dp) // Small padding to the start of the text
                )
            }
        }
        Row (modifier = Modifier.padding(start =16.dp) ){
            Row {
                Icon(painter =painterResource(id = R.drawable.location), contentDescription ="Location")
                Text (
                    text = salons.address,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,
                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
        Button(
            onClick = { }, //navController.navigate("beautySalon/${salon.id}")
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .requiredWidth(width = 326.dp)
            ) {
                Text(text = "View")
            }
        }
    }
}


@Composable
@Preview (widthDp = 390, heightDp = 844)
fun HomePreview(){
    Home();
}