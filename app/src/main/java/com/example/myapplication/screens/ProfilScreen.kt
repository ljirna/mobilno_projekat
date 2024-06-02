package com.example.myapplication.screens




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.model.SalonObject
import com.example.myapplication.model.Salons
import com.example.myapplication.model.models.Salon

import androidx.compose.material3.Text as Text1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var showFavorites by remember { mutableStateOf(false) }


    Column(Modifier.fillMaxHeight()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp) // Adjust height as needed
                .background(color = Color(0xffb36370))
        ) {
            // Header content
            Text(
                text = "Profile",
                color = Color.White,
                style = TextStyle(
                    fontSize = 20.sp
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .offset(y = 70.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(
                    id = R.drawable.profile_photo
                ),
                contentDescription = "",
                Modifier
                    .clip(CircleShape)
                    .size(150.dp)
            )

            Row(Modifier.offset(y = 30.dp)) {
                IconButton(onClick = { showFavorites = false },
                    modifier = Modifier.size(24.dp),
                    content = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.user
                            ),
                            contentDescription = "",
                            Modifier.size(24.dp),
                            Color(color = 0xffb36370)
                        )
                    }
                )

                Spacer(Modifier.size(40.dp))
                IconButton(onClick = { showFavorites = true },
                    modifier = Modifier.size(24.dp),
                    content = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.reacted_favorite_24
                            ),
                            contentDescription = "",
                            Modifier.size(24.dp),
                            Color(color = 0xffb36370)
                        )
                    }

                )
            }

            Spacer(Modifier.size(30.dp))

            if (showFavorites) {
                display()

            } else {
                UserInfo(
                    name = "Emina Peljto",
                    email = "emina@gmail.com",
                    phone = "061 123 456",
                    onNameChange = { name = it },
                    onEmailChange = { email = it },
                    onPhoneChange = { phone = it }
                )
            }
        }
    }
}

@Composable
fun Title(title: String){
    Text(text = "$title", style = TextStyle(fontSize = 20.sp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfo (name: String, email: String, phone: String, onNameChange: (String) -> Unit, onEmailChange: (String) -> Unit, onPhoneChange: (String) -> Unit){
    Column(
        Modifier.padding(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { onNameChange(it) },
            label = { Text("Full Name")},
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White, // Background color
                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                unfocusedIndicatorColor = Color.Transparent // Remove underline when not focused
            ),
            shape = RoundedCornerShape(8.dp)
        )
        TextField(
            value = email,
            onValueChange = { onEmailChange(it) },
            label = { Text(text = "Email")},
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White, // Background color
                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                unfocusedIndicatorColor = Color.Transparent // Remove underline when not focused
            ),
            shape = RoundedCornerShape(8.dp)
        )
        TextField(
            value = phone,
            onValueChange = { onPhoneChange(it) },
            label = { Text(text = "Phone")},
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            ,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White, // Background color
                focusedIndicatorColor = Color.Transparent, // Remove underline when focused
                unfocusedIndicatorColor = Color.Transparent // Remove underline when not focused
            ),
            shape = RoundedCornerShape(8.dp)
        )

        Row(){
            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                modifier = Modifier
                    .width(180.dp)
                    .height(70.dp)
                    .padding(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .requiredWidth(width = 180.dp)
                ) {
                    Text(text = "Edit Profile")
                }
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                modifier = Modifier
                    .width(180.dp)
                    .height(70.dp)
                    .padding(10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .requiredWidth(width = 180.dp)
                ) {
                    Text(text = "Log Out")
                }
            }
        }
    }
}

@Composable
fun display(){
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        SalonObject.salons.forEach { salon ->
            favorites(salon)
        }
    }
}

@Composable
fun favorites(salons: Salons){
    Column (
        modifier = Modifier
            .offset(y = 15.dp)
            .padding(25.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .shadow(20.dp)
            .background(Color.White)
            .border(
                width = 2.dp,  // specify the width of the border
                color = Color.Gray,  // specify the color of the border
                shape = RoundedCornerShape(15.dp)  // make sure the shape matches the clip shape
            )
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
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.size(24.dp)) {

                    Icon(
                        painter = painterResource(id = R.drawable.reacted_favorite_24),
                        contentDescription = "",
                        tint = Color(0xffb36370),
                        modifier = Modifier.requiredSize(size = 24.dp)
                    )
                }
            }
        }
        Row (modifier = Modifier.padding(start =16.dp) ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Location"
                )
                Text(
                    text = salons.address,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )

            }
        }
        Spacer(modifier = Modifier.size(10.dp))
    }
}



@Preview
@Composable
fun favoritesPreview(){
    display();
}

@Preview(widthDp = 390, heightDp = 844)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

