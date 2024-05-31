package com.example.myapplication.screens

import com.example.myapplication.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.material3.Text as Text1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column (Modifier.fillMaxHeight()) {
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
            Image(painter = painterResource(
                id = R.drawable.profile_photo),
                contentDescription = "",
                Modifier
                    .clip(CircleShape)
                    .size(150.dp)
            )

            Row (Modifier.offset(y = 30.dp)){
                Icon(painter = painterResource(
                    id = R.drawable.user),
                    contentDescription = "",
                    Modifier.size(24.dp),
                    Color(color = 0xffb36370)
                )
                Spacer(Modifier.size(40.dp))
                Icon(painter = painterResource(
                    id = R.drawable.user),
                    contentDescription = "",
                    Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.size(30.dp))

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Emina Peljto")},
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
                onValueChange = { email = it },
                label = { Text(text = "emina.peljto@gmail.com")},
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
                onValueChange = { phone = it },
                label = { Text(text = "+386 62837470")},
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

            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                modifier = Modifier
                    .width(200.dp)
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


        }

    }
}

@Composable
fun Title(title: String){
    Text(text = "$title", style = TextStyle(fontSize = 20.sp))
}


@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(Modifier)
}
