@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
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
import com.example.myapplication.R
import androidx.compose.material3.Text as Text1

@Composable
fun SignupScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .requiredWidth(390.dp)
            .requiredHeight(844.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 385.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Name",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = name,
                onValueChange = { newName -> name = newName },
                modifier = Modifier
                    .offset(x = 0.dp, y = 20.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 465.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Email",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = email,
                onValueChange = { newEmail -> email = newEmail },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 20.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp) // Increased height for better visibility
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 545.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Phone Number",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = phoneNumber,
                onValueChange = { newPhoneNumber -> phoneNumber = newPhoneNumber },
                modifier = Modifier
                    .offset(x = 0.dp, y = 21.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp) // Increased height for better visibility
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 625.dp)
                .requiredWidth(342.dp)
        ) {
            Text1(
                text = "Password",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .offset(x = 10.dp, y = 0.dp)
            )
            TextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                modifier = Modifier
                    .offset(x = 0.dp, y = 21.dp)
                    .requiredWidth(342.dp)
                    .requiredHeight(56.dp) // Increased height for better visibility
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Text1(
            text = "Glamify Me",
            color = Color.Black,
            style = TextStyle(fontSize = 48.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 64.dp, y = 280.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Glamify Me Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 80.dp)
                .requiredWidth(188.dp)
        )

        Button(
            onClick = { },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 25.dp, y = 710.dp)
                .requiredWidth(342.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.requiredWidth(342.dp)
            ) {
                Text1(
                    text = "Sign Up",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp)
                )
            }
        }

        Text1(
            text = "Have an account?",
            color = Color.LightGray,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 110.dp, y = 755.dp)
        )

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 255.dp, y = 755.dp)
        ) { }

        Text1(
            text = "Log In",
            color = Color.Black,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 225.dp, y = 755.dp)
        )
    }
}

@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun SignupScreenPreview() {
    SignupScreen(Modifier)
}