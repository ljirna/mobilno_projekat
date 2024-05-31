@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.screens

import android.util.Log
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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.viewModel.AppViewModelProvider
import com.example.myapplication.viewModel.LoginViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.Text as Text1

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)) {

    val userUiState = viewModel.userUiState
    val coroutineScope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .requiredWidth(width = 390.dp)
            .requiredHeight(height = 844.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp, y = 465.dp)
                .requiredWidth(width = 342.dp)
                .requiredHeight(height = 47.dp)
        ) {
            Text1(
                text = "Email",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 10.dp, y = -4.dp)
            )
            TextField(
                value = email,
                onValueChange = {
                        newEmail -> email = newEmail
                    viewModel.updateEmail(newEmail)
                },
                placeholder = { Text1(text = "Enter your email address") },
                modifier = Modifier
                    .offset(x = 0.dp, y = 21.dp)
                    .requiredWidth(width = 342.dp)
                    .requiredHeight(height = 56.dp) // Increased height for better visibility
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color(0xFFF0F0F0)) // Background color for better visibility
                    .padding(horizontal = 0.dp),
                textStyle = TextStyle(color = Color.Black) // Set the text color to black
            )
        }

        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp, y = 555.dp)
                .requiredWidth(width = 342.dp)
                .requiredHeight(height = 47.dp)
        ) {
            Text1(
                text = "Password",
                color = Color(0xff333333),
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 10.dp, y = -4.dp)
            )
            TextField(
                value = password,
                onValueChange = {
                        newPassword -> password = newPassword
                    viewModel.updatePassword(newPassword)
                },
                placeholder = { Text1(text = "Enter your password") },
                modifier = Modifier
                    .offset(x = 0.dp, y = 21.dp)
                    .requiredWidth(width = 342.dp)
                    .requiredHeight(height = 56.dp) // Increased height for better visibility
                    .clip(shape = RoundedCornerShape(10.dp))
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
                .align(alignment = Alignment.TopStart)
                .offset(x = 64.dp, y = 313.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Glamify Me Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(y = 120.dp)
                .requiredWidth(width = 188.dp)
        )

        Button(
            onClick = {
                coroutineScope.launch {
                    Log.d("Pre signup", viewModel.userUiState.toString())
                    viewModel.signInUser { isLoggedIn, error ->
                        if (isLoggedIn) {
                            Log.d("Register", viewModel.userUiState.toString())
                        } else {
                            Log.d("Register", "Registration failed: $error")
                        }
                    }
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffb36370)),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp, y = 648.dp)
                .requiredWidth(width = 342.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.requiredWidth(width = 342.dp)
            ) {
                Text1(
                    text = "Log In",
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp)
                )
            }
        }

        Text1(
            text = "Don’t have an account?",
            color = Color.LightGray,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 99.dp, y = 702.dp)
        )

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 255.dp, y = 690.dp)
        ) { }

        Text1(
            text = "Sign Up",
            color = Color.Black,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 245.dp, y = 702.dp)
        )
    }
}

@Preview(widthDp = 390, heightDp = 844)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}
